Building Bootiful Microservices with Spring Cloud


Task A : Build a Restful Spring Boot Service

	Step 1: Build a rest project using spring boot - reservation-service 

Task B : Make reservation-service to read configuration from a central repository and should be refresh-able

	Step 1: Build a config-service using @EnableConfigServer on main file
	Step 2: Add spring cloud client dependency to reservation-service
	Step 3: Read properties from github central file
	Step 4: Update properties in github 
	Step 5: Issue an empty post to reservation-service
		curl -d {} http://localhost:8000/refresh to reload new properties
	Step 6: without restarting anyone server, just reload the page and observe new value
	
	
Task C : Build a service registry. Client needs a directory to whom to call. Inorder to set that up 
we use a service registry. A service registry is like a phone book for cloud services. 
We will use Eureka Server

	Step 1: Build a eureka-service using @EnableEurekaServer on main file
	Step 2: Add spring-cloud-starter-eureka dependency to reservation-service
	Step 3: Enable @EnableDiscoveryClient on reservation-service main file
	Step 4: Restart reservation-service and wait for 30 sec to see 
	reservation-service on Eureka http://localhost:8761/

Task D : Build a client reservation-client for the reservation-service

Task E : Integrate power of circuit breaker

Task F : Use Hystrix Dashboard to monitor circuits 
