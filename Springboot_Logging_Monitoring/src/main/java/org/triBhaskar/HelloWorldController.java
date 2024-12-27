package org.triBhaskar;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Timed
public class HelloWorldController {

    @Autowired
    private ItemService itemService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final Counter requestCounter;

    public HelloWorldController(MeterRegistry meterRegistry) {
        this.requestCounter = meterRegistry.counter("total.requests");
    }

    @GetMapping("/hello-world")
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        requestCounter.increment();
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/books")
    @Timed("books.api")
    public String orderBook() {
        requestCounter.increment();
        return itemService.orderBook();
    }

    @PostMapping("/movies")
    @Timed("movies.api")
    public String orderMovie() {
        requestCounter.increment();
        return itemService.orderMovie();
    }

}
