package com.anterka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ActuatorDemoController {

    private final HealthEndpoint healthEndpoint;
    private final InfoEndpoint infoEndpoint;
    private final MetricsEndpoint metricsEndpoint;

    @Autowired
    ActuatorDemoController(HealthEndpoint healthEndpoint, InfoEndpoint infoEndpoint, MetricsEndpoint metricsEndpoint) {
        this.healthEndpoint = healthEndpoint;
        this.infoEndpoint = infoEndpoint;
        this.metricsEndpoint = metricsEndpoint;
    }

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> endpoints = new HashMap<>();
        endpoints.put("message", "Spring Boot Monitoring Demo Application");
        endpoints.put("actuator_endpoints", Map.of(
            "health", "/actuator/health",
            "info", "/actuator/info",
            "metrics", "/actuator/metrics",
            "prometheus", "/actuator/prometheus",
            "beans", "/actuator/beans",
            "env", "/actuator/env",
            "configprops", "/actuator/configprops",
            "mappings", "/actuator/mappings",
            "loggers", "/actuator/loggers"
        ));
        endpoints.put("demo_endpoints", Map.of(
            "hello", "/api/hello",
            "metrics_demo", "/api/metrics-demo",
            "business_metrics", "/api/business-metrics",
            "error_demo", "/api/error-demo"
        ));
        endpoints.put("admin_ui", "http://localhost:8080");
        return endpoints;
    }

    @GetMapping("/health-summary")
    public Object healthSummary() {
        return healthEndpoint.health();
    }

    @GetMapping("/app-info")
    public Object appInfo() {
        return infoEndpoint.info();
    }

    @GetMapping("/metrics-list")
    public Object metricsList() {
        return metricsEndpoint.listNames();
    }
}
