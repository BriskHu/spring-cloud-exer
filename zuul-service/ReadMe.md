# Zuul——网关服务

**注意：** 
使用Zuul作为网关服务时，需要在项目的pom中导入Eureka-client的包，也即Zuul服务要作为一个Eureka 的client。在springboot2.0.3以后
Eureka client的依赖是“”。在pom中导入这个依赖后，只需要在配置文件中增加一个“eureka.client.service-
url.defaultZone=http://localhost:9002/eureka/” 配置即可。这里的“http://localhost:9002/eureka/” 是Eureka 注册中心服务端
的地址。


配置路由的关键是service-id和path要匹配一致。如下例

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
