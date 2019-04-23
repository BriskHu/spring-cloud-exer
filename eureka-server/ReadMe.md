# Eureka练习项目——注册中心服务端

Eureka 注册中心的服务端程序很简单。如果只需要实现基本的注册中心，则只需要两步即可：1. 将主类加上@EnableEurekaServer注解；
2. 在配置中心中配置好eureka.instance.hostname等属性即可。

注意因为这个服务是注册中心的server，所以配置文件中“eureka.client.register-with-eureka”和
“eureka.client.fetch-registry”都设成false。eureka.client.register-with-eureka是配置是否要注册到
Eureka。由于自己就是服务器，不需要注册到自己，所以设为false。eureka.client.fetch-registry是指是否从
注册中兴获取注册信息。由于自己就是服务器，不需要从服务器获取注册信息，所以设为false。
另外“eureka.service-url.default-zone”不要和“eureka.client.service-url.default-zone”搞混了。