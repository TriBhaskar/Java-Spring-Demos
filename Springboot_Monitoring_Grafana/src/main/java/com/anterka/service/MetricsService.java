package com.anterka.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MetricsService {

    private final Counter businessOperationCounter;
    private final Timer businessProcessingTimer;
    private final DistributionSummary orderValueSummary;
    private final MeterRegistry meterRegistry;
    private final Random random = new Random();

    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        // Counter for business operations
        this.businessOperationCounter = Counter.builder("business_operations_total")
                .description("Total number of business operations")
                .tag("type", "order")
                .register(meterRegistry);

        // Counter for errors
        Counter errorCounter = Counter.builder("business_errors_total")
                .description("Total number of business errors")
                .register(meterRegistry);

        // Timer for business processing time
        this.businessProcessingTimer = Timer.builder("business_processing_time")
                .description("Time taken to process business operations")
                .register(meterRegistry);

        // Distribution summary for order values
        this.orderValueSummary = DistributionSummary.builder("order_value")
                .description("Distribution of order values")
                .baseUnit("USD")
                .register(meterRegistry);
    }

    public void recordBusinessOperation() {
        Timer.Sample sample = Timer.start();

        try {
            // Simulate business processing
            Thread.sleep(random.nextInt(200) + 50); // 50-250ms processing time

            // Record successful operation
            businessOperationCounter.increment();

            // Record order value (simulated)
            double orderValue = 10.0 + (random.nextDouble() * 990.0); // $10-$1000
            orderValueSummary.record(orderValue);

        } catch (InterruptedException e) {
            recordError("processing_interrupted");
            Thread.currentThread().interrupt();
        } finally {
            sample.stop(businessProcessingTimer);
        }
    }

    public void recordError(String errorType) {
        // Create a counter with tags for different error types
        Counter.builder("business_errors_by_type")
                .description("Business errors by type")
                .tag("error_type", errorType)
                .register(meterRegistry)
                .increment();
    }

    public void recordCustomMetric(String metricName, double value) {
        // This method can be used to record custom metrics dynamically
        meterRegistry.gauge(metricName, value);
    }
}
