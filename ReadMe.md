# Spring Cloud 练习项目

本项目包含如下内容：
- Eureka练习项目；包括 eureka-server(注册中心服务端)、eureka-client(注册中心客户端)；
- Zuul练习项目；
- Ribbon练习项目；
- Hystrix练习项目；
- Spring Cloud Config练习项目；
- Dubbo练习项目；
- RocketMQ练习项目；
- Feign练习项目；
- Spring Cloud Sleuth练习项目；
- Zipkin练习项目；
- Liquibase练习项目；
- Swagger练习项目；
- Spring Security练习项目；
- Mockito练习项目。


## 项目结构


## 常用指令

### 单模块打包

如果需要仅仅将某个子模块进行打包，可以在项目根路径下，打开命令行使用下面这个指令即可：
```
mvn clean package -DskipTests -pl :module-name -am
```

比如，要对 eureka-server 子项目打包的指令是：
```
mvn clean package -DskipTests -pl :eureka-server -am
```
