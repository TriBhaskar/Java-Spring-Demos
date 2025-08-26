package com.anterka.controller;

import com.anterka.service.MetricsService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
public class MetricsController {

    private final Counter requestCounter;
    private final Timer responseTimer;
    private final AtomicInteger activeUsers = new AtomicInteger(0);
    private final Random random = new Random();

    private final MetricsService metricsService;

    @Autowired
    public MetricsController(MeterRegistry meterRegistry, MetricsService metricsService) {
        this.metricsService = metricsService;
        // Counter - counts total requests
        this.requestCounter = Counter.builder("api_requests_total")
                .description("Total number of API requests")
                .tag("endpoint", "metrics")
                .register(meterRegistry);

        // Timer - measures response time
        this.responseTimer = Timer.builder("api_response_time")
                .description("API response time")
                .register(meterRegistry);

        // Gauge - tracks current active users (correct syntax)
        Gauge.builder("active_users", activeUsers, AtomicInteger::get)
                .description("Current number of active users")
                .register(meterRegistry);
    }

    @GetMapping("/hello")
    public String hello() {
        try {
            return responseTimer.recordCallable(() -> {
                return "Hello from Spring Boot with custom metrics!";
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/metrics-demo")
    public String metricsDemo() {
        // Increment counter
        requestCounter.increment();

        Timer.Sample sample = Timer.start();

        try {
            Thread.sleep(random.nextInt(100)); // Random delay 0-100ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        sample.stop(responseTimer);

        // Update active users randomly
        activeUsers.set(random.nextInt(50));

        return "Metrics demo executed! Check /actuator/prometheus for metrics.";
    }

    @GetMapping("/business-metrics")
    public String businessMetrics() {
        metricsService.recordBusinessOperation();
        return "Business operation recorded! Check custom business metrics.";
    }

    @GetMapping("/error-demo")
    public String errorDemo() {
        if (random.nextBoolean()) {
            throw new RuntimeException("Simulated error for metrics demonstration");
        }
        return "Success response";
    }
}
