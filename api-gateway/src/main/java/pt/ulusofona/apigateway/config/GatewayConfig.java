package pt.ulusofona.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayConfig {

    //@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // User Service routes
                .route("user-service", r -> r
                        .path("/api/users/**")
                        // MUDOU DE localhost PARA user-service
                        .uri("http://user-service:8081"))

                // Product Service routes
                .route("product-service", r -> r
                        .path("/api/products/**")
                        // MUDOU DE localhost PARA product-service
                        .uri("http://product-service:8082"))

                // Order Service routes
                .route("order-service", r -> r
                        .path("/api/orders/**")
                        // MUDOU DE localhost PARA order-service
                        .uri("http://order-service:8083"))

                .build();
    }
}