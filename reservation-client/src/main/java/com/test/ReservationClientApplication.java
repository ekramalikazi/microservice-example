package com.test;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.test.client.ReservationsRestClient;
import com.test.entity.Reservation;

@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
@EnableCircuitBreaker 
@SpringBootApplication
public class ReservationClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationClientApplication.class, args);
    }
    
    /*Low level call */
    @Bean 
    CommandLineRunner dc(DiscoveryClient dc) {
        return args -> 
                dc.getInstances("reservation-service")
                        .forEach(si -> System.out.println(
                        		si.getServiceId() + ' ' + 
                                si.getHost() + ':' + si.getPort())); 
    } 
    
    @Bean 
    CommandLineRunner rt(RestTemplate restTemplate) {
        return args -> { 
            ParameterizedTypeReference<List<Reservation>> ptr 
                    = new ParameterizedTypeReference<List<Reservation>>() {
            }; 
 
 
            List<Reservation> reservations = restTemplate.exchange( 
                    "http://reservation-service/reservations", 
                    HttpMethod.GET, null, ptr).getBody(); 
 
 
            reservations.forEach(System.out::println); 
        }; 
    } 
    
    @Bean 
    CommandLineRunner feign(ReservationsRestClient client) {
        return args -> 
                client.getReservations().forEach(System.out::println);
    } 
}
