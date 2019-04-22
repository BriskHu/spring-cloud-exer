# Eureka练习项目——注册中心服务端

Eureka 注册中心的服务端程序很简单。如果只需要实现基本的注册中心，则只需要两步即可：1. 将主类加上@EnableEurekaServer注解；
2. 在配置中心中配置好eureka.instance.hostname等属性即可。

注意因为这个服务是注册中心的server，所以配置文件中“eureka.client.register-with-eureka”和
“eureka.client.fetch-registry”都设成false。