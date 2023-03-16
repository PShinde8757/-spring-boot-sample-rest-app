package com.PS.restservices.Controller;


import java.util.concurrent.atomic.AtomicLong;
import com.PS.restservices.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class GreetingController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greet")
    public Greeting greeting(@RequestParam(value= "name", defaultValue = "World") String name,
                             @RequestParam(value = "age", defaultValue = "25") int age)  {
        log.info("Request received : name : {} and age: {}",name, age);
        return new Greeting(counter.incrementAndGet(), String.format(template, name), age);
    }
}
