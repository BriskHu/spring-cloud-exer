# 为负载均衡服务提供网关服务

负载均衡通常与网关服务一起工作：请求首先通过网关，网关对请求进行预处理，然后在转发到具体的服务组件。

## 本项目联调方式
涉及到的模块：zuul-loadbalance、loadbalance-service、eureka-service、order-service1、order-service2.

联调步骤：
1. 首先启动的eureka-service组件。
2. 再启动zuul-service、loadbalance-service、order-service1、order-service2.
3. 以访问Zuul服务的方式访问负载均衡组件提供的服务。

