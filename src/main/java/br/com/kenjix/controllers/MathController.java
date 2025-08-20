package br.com.kenjix.controllers;

import br.com.kenjix.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/math")
public class MathController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/math/sum/1/3
    @RequestMapping("/sum")
    public Greeting greeting(
            @RequestParam(value="name", defaultValue = "world")
            String name){
        return  new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}