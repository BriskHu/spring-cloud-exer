# Eureka练习项目——注册中心客户端

Eureka 注册中心的服务端程序很简单。如果只需要实现基本的注册中心，则只需要两步即可：1. 将主类加上@EnableEurekaServer注解；
2. 在配置中心中配置好eureka.instance.hostname等属性即可。

**注意：** 

1. 配置文件中的“eureka.client.service-url.defaultZone”里的defaultZone要采用驼峰方式，而不能写成连接线
形式（即default-zone），否则会导致启动失败，报“Request execution error. endpoint=
DefaultEndpoint{ serviceUrl='http://localhost:8761/eureka/}”错误。

2. Eureka Client 需要导入springboot 的 web包才能运行，否则将会出现程序启动后立即就自动正常结束了。
