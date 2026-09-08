package com.vietmart.gateway;

import com.vietmart.loadbalancer.zone.ZonePreferenceLBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

@SpringBootApplication
// Chỉ cấu hình Zone Preference áp dụng riêng cho order-service
@LoadBalancerClients({
    @LoadBalancerClient(name = "order-service", configuration = ZonePreferenceLBConfig.class)
})
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}