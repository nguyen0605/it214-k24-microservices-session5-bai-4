package com.vietmart.loadbalancer.zone;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Class này KHÔNG sử dụng annotation @Configuration để tránh bị quét tự động
 * Chỉ được nạp khi chỉ định cụ thể qua @LoadBalancerClient
 */
public class ZonePreferenceLBConfig {
    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(
            ConfigurableApplicationContext context) {
        return ServiceInstanceListSupplier.builder()
                .withDiscoveryClient()
                .withZonePreference()
                .withHealthChecks()
                .build(context);
    }
}