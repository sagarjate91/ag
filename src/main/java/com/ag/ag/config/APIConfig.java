package com.ag.ag.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("payment-service", r -> r.path("/api/payments/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("payment-cb")
                                .setFallbackUri("forward:/paymentServiceFallBack")))
                        .uri("lb://PS"))
                .route("order-service", r -> r.path("/api/orders/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("order-cb")
                                .setFallbackUri("forward:/orderServiceFallBack")))
                        .uri("lb://OS"))
                .build();
    }
}
