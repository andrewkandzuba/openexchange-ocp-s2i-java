package io.openexchange.openexchange.ocp.s2i.java.rest;

import io.openexchange.openexchange.ocp.s2i.java.model.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {

    private static final String MESSAGE_TEMPLATE = "Hello %s!";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings")
    public HelloWorld greetings(@RequestParam(value = "name", defaultValue = "World") String name) {
        return HelloWorld.builder()
                .id(counter.incrementAndGet())
                .message(String.format(MESSAGE_TEMPLATE, name))
                .build();
    }
}
