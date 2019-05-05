# Zuul——网关服务

## Zuul服务的实现
要点有两个：
1. 在主类上使用@EnableZuulProxy和@EnableDiscoveryClient注解，使Web服务具有Zuul、EurekaClient服务的能力。
2. 在application.properties文件中使用eureka.client.service-url.defaultZone来指定Eureka注册中心的Url，使用zuul.routes.xx.serviceId、
zuul.routes.xx.path来完成服务serviceId的路由设置，使用zuul.routes.xx.path和zuul.routes.xx.url来完成服务url的路由设置。这里的“xx”
对应于具体服务的服务名称。这个名称可以是服务配置文件中spring.application.name属性的值，也可以是任意的值。只要这三个参数的xx保持一致即可。

**注意：** 
1. 使用Zuul作为网关服务时，需要在项目的pom中导入Eureka-client的包，也即Zuul服务要作为一个Eureka 的client。在springboot2.0.3以后
Eureka client的依赖是“”。在pom中导入这个依赖后，只需要在配置文件中增加一个“eureka.client.service-
url.defaultZone=http://localhost:9002/eureka/” 配置即可。这里的“http://localhost:9002/eureka/” 是Eureka 注册中心服务端
的地址。

2. 配置路由的关键是service-id和path要匹配一致。如下例

```
# routes to service id
## the first service
zuul.routes.service01.service-id=service01
zuul.routes.service01.path=/service01/**
## the second service
zuul.routes.service02.service-id=service02
zuul.routes.service02.path=/service02/**

# routes to the url
zuul.routes.service01-url.path=/service01/**
zuul.routes.service01-url.url=http://localhost:9003/

zuul.routes.service02-url.path=/service02/**
zuul.routes.service02-url.url=http://localhost:9004/
```

上述示例配置，显示了两种配置：通过path配置路由、通过url配置路由。

### 通过path配置路由

这种方式需要配置service-id和path两项。 配置项 ``` zuul.routes.service01.service-id=service01 ```表示需要进行
路由的组件的名字。其中等号后面的名字应该是需要进行路由的组件的spring.application.name的值。等号前面的
“service01”是任意设定的一个名字，用于在配置文件中表明当前是配置的哪个zuul.routes节点。配置项
 ```  zuul.routes.service01.path=/service01/** ``` 表示该zuul.routes节点对应的请求路径。等号后面是这个
 zuul.routes节点具体的路径，等号前面的“service01”需要与前一项“zuul.routes.service01.service-id=service01”
 中等候左边的service01保持一致。这样一组的两个配置项就完成一个zuul.routes节点的path路由配置。

### 通过url配置路由

这种方式需要配置url和path两项。配置项 ``` zuul.routes.service01-url.url=http://localhost:9003/ ``` 表示需要进行路由的
组件的原始服务路径。等号左边的"service01-url"指定当前配置的是哪个zuul.routes节点。等号右边的url路径是组件的原始
服务路径。配置项 ``` zuul.routes.service01-url.path=/service01/** ``` 表示该zuul.routes节点通过zuul管理后的
服务路径。通过这两个配置项实现将原来 http://localhost:9003/ 下的所有请求转换到现在zuul服务路径下"/service01/"
的全部请求。



上述示例配置中，zuul.routes配置后面的service01或service02可以是任意值，只要path和serviceId是成对出现的即可。
比如上例中，所有“/service01/** ”过来的请求都会转发到service01这个服务上。而所有“http://localhost:9003/”过
来的请求也都会转发到“/service01/** ”这个路径上，从而转发到service01这个服务上。注意，这里的
“zuul.routes.service01.service-id=service01”中的service01与对应服务项目的spring.application.name的值保
持一致。否则，可能会报找不到服务的错。

注意：在配置网关时，要注意
“zuul.routes.loadbalance.path=/LOaDBALANCE/**”这个属性配置的是url请求路径。也就是说，所有以当前项目的
请求路径前缀+这个路径的请求都会交给这个“loadbalance”组件进行处理。比如本练习项目的请求前缀为
“http://localhost:9009”，则所有以“http://localhost:9009/LOaDBALANCE/”开头的请求都会交给这个“loadbalance”
组件进行处理。

完成上述路由配置后，既可以通过serviceId的方式来进行跳转访问服务，也可以通过url的方式来跳转。

## Zuul示例程序的构成和调试
要演示Zuul的网关作用，至少需要四个服务：Eureka-server（注册中心服务端）、Zuul-service（承载Zuul的服务）、两个不同
的eurek-client用来展示路由配置。对应于本项目，注册中心服务端是eureka-server模块，Zuul服务是zuul-service模块，
eureka-client01、eureka-client02是两个一般的客户端程序。

运行时，首先启动 eureka-server模块，然后启动eureka-client01、eureka-client02、zuul-service模块。后三个模块没有
启动先后顺序之分。启动完成后，在Eureka的监控页面会看到有三个注册的实例。然后就可以分别通过serviceId、url的方式来
验证请求的路由是否成功。