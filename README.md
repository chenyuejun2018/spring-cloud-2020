# spring-cloud-2020 

微服务技术

微服务架构是一种机构模式，它提倡将单一应用程序划分成一组小的服务。服务之间相互协调，相互配合，为用户提供最终的价值。每个服务运行在其独立的进程中，服务与服务之间采用轻量级的通信机制相互协作（通常是基于HTTP协议的RESETful API）。每个服务都围绕着具体业务进行构建。并且能够被独立的部署到生产环境，准生产环境等。另外，应当尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务上下文，选择合适的语言，工具对其进行构建。

springcloud技术的项目举例，有关技术的详细介绍参阅官方文档

项目基于spring boot 2.2.2.RELEASE 

Springcloud consul 服务注册中心		

	版本：consul_1.7.1_linux_amd64.zip 【107服务器】
	
	项目 		
		cloud-consumer-consul-order80 【消费者】	
		
		cloud-provider-consul-payment8006 【生产者】		

Springcloud Eureka 服务注册中心	
	
	版本：与spring boot 2.2.2.RELEASE匹配	
	
	项目：cloud-consumer-order80【消费者】		
		
		cloud-euraka-server7001 【注册中心集群】
		
		cloud-eureka-server7002 【注册中心集群】
		
		cloud-provider-payment8001【生产者集群】
		
		cloud-provider-payment8002【生产者集群】		
				
Springcloud Gateway 微服务网关	
			
	版本：与spring boot 2.2.2.RELEASE匹配		
	
	项目：cloud-gateway-gw9527  【微服务网关】		
		
		cloud-euraka-server7001 【注册中心集群】	
		
		cloud-eureka-server7002 【注册中心集群】	
		
		cloud-provider-payment8001 【生产者集群】	
		
		cloud-provider-payment8002 【生产者集群】	
		
	请求网关：http://localhost:9527/payment/get/106		

Springcloud Hystrix  服务降级(断路器)	
	
	版本：与spring boot 2.2.2.RELEASE匹配		
	
	项目：cloud-consumer-feign-hystrix-order80【消费者】		
		
		cloud-eureka-hystrix-server7003     【注册中心】	
		
		cloud-provider-hystrix-payment8008  【生产者】		
		
		cloud-consumer-hystrix-dashboard9001【监控页面】		

Springcloud OpenFeign 微服务调用和Ribbon负载均衡(openfeign集成了Ribbon)	
	
	版本：与spring boot 2.2.2.RELEASE匹配		
	
	项目：cloud-consumer-feign-order80 【消费者】		
	
		cloud-euraka-server7001 【注册中心集群】		
		
		cloud-eureka-server7002 【注册中心集群】		
		
		cloud-provider-payment8001【生产者集群】		
		
		cloud-provider-payment8002【生产者集群】		
			
SpringCloud Bus消息总线和Config分布式配置中心（需要安装RabbitMQ和用到Git仓库）	
	
	版本：与spring boot 2.2.2.RELEASE匹配	
	
	项目：cloud-euraka-server7001【注册中心集群】	
		
		cloud-euraka-server7002【注册中心集群】	
		
		cloud-config-center2020【配置中心服务端】	
		
		cloud-config-client2021【配置中心客户端】	
		
		cloud-config-client2021【配置中心客户端】		
			
SpringCloud Stream消息驱动(springcloud只支持RabbitMQ、Kafka)以RabbitMQ为例		

	版本：Stream与spring boot 2.2.2.RELEASE匹配		
	
		  RabbitMQ版本rabbitmq-server-3.7.14_otp_win64_21.3	
		  
	项目：cloud-stream-rabbitmq-consumer2026 【消费者】
		
		cloud-stream-rabbitmq-consumer2027 【消费者】	
		
		cloud-stream-rabbitmq-provider2025 【生产者】	
		
		cloud-euraka-server7001 【注册中心集群】
		
		cloud-eureka-server7002 【注册中心集群】		
		
SpringCloud Zookeeper服务注册中心		

	版本：zookeeper-3.5.3-beta.zip	{CenterOS安装}			
	项目：				
		cloud-consumer-zk-order80 【消费者】		
		
		cloud-provider-zookeeper-payment8004 【生产者】		
		
SpringCloud Sleuth+Zipkin 分布式请求链路跟踪		

	版本：zipkin-server-2.12.9-exec.jar	
	
	项目：添加zipkin的配置
	
		cloud-euraka-server7001		
		
		cloud-euraka-server7002		
		
		cloud-provider-payment8001	
		
		cloud-provider-payment8002		
		
	zipkin下载https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/2.12.9/zipkin-server-2.12.9-exec.jar		
	
	运行JAR包；java -jar zipkin-server-2.12.9-exec.jar		
	
	访问监控界面地址：http://loaclhost:9411/zipkin/		

