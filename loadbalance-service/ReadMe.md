# Ribbon服务——负载均衡

## 利用Ribbon实现简单的负载均衡

### 思路
利用@LoadBalance注解，将Springboot原生处理客户端请求的RestTemplate转换为使用Ribbon进行均在均衡的实例对象。
对需要进行负载均衡的请求先使用这个强化的RestTemplate进行处理。在@LoadBalance注解的作用下，负载均衡算法会根据请求
选择调用合适的服务实例进行具体的业务处理。

### 实现步骤
涉及的模块：loadbalance-service、order-service1、order-service2。

1. 创建负载均衡服务 

要点有两个：配置主类；增加controller，管理需要进行负载均衡的接口。

配置主类

新建一个springboot的web项目。这个项目是Eureka客户端，即要增加eureka-client依赖。然后在这个项目的启动类上加上
@EnableDiscoveryClient注解。在主类里面增加一个具有负载均衡能力的RestTemplate实例，代码如下：
```
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
```

增加controller，管理需要进行负载均衡的接口

增加一个普通的controller类，然后在这个类中增加下面的方法，对接口进行负载均衡：

```
    @GetMapping("/order/hello")
    public String orderHello(){
        LOGGER.info("[orderHello] 入参：无入参。");
        return restTemplate.getForEntity("http://ORDER-SERVICE/hello", String.class).getBody();
    }
```

其中的url——“http://ORDER-SERVICE/heelo”中的ORDER-SERVICE要与具体的接口实现服务程序的spring.application.name
的值保持一致。
**注意：** 负载均衡controller中的这个ORDER-SERVICE必须是全部大写的，否则会报找不到实例错误。这是因为
具体接口服务中spring.application.name的这个值不管是大写、小写，因为Eureka会默认自动把所有注册的服务名转为全部大
写的。但是，坑的地方是，在eureka管理界面中实例的status状态处展示具体接口服务名又是与spring.application.name的值
保持一致的。

2. 接口具体实现服务

接口具体实现的服务就是普通的Eureka client项目，同一个接口需要几个服务来协同处理请求就创建几个完全相同的client项目
即可。唯一需要改的是，这些协同服务的配置文件中的spring.application.name要保持相同，另外是每个项目的端口号要保持
不同。

**注意：** 如果服务提供者重启后，需要重启负载均衡程序和注册中心服务。否者可能会出现找不到服务的问题。
另外，如果是同一个服务的多个实例程序，这些程序的spring.application.name要保持一样，但是server.port
要不一样。这样才能进行负载均衡。

通过loadbalance-service的日志可以看出：当负载均衡发出请求，会根据服务名到注册中心上把所有的服务实例都找到，保存
到服务列表当中，这样即使注册中心宕机了，由于缓存了服务列表，也不影响正常使用。

当其中一个实例注销或重启后，由于服务列表的更新需要时间，这个时间和服务本身设定的失效间隔有关，设置时间越短，从注
册中心剔除这个实例的时间就越短，这样更新服务列表就会更加即时，能保证请求不再去调用已经停止的服务实例。

## 结合Zuul实现 网关+负载均衡

实际中请求一般不会直接发送到负载均衡服务上面，在它前面需要有一个网关。请求的处理流程如下：调用方不再是从负载均衡
服务直接发起，改为由网关路由到负载均衡服务上，然后由负载均衡服务再将请求进行分发，发送到不同的实例上。

增加一个Zuul-service服务，在配置中增加对负载均衡的路由。

测试时，是用户在前端请求“Zuul-service服务名:端口/loadbalance-service/具体接口”来调用的。