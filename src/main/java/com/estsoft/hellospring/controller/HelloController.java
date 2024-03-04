package com.estsoft.hellospring.controller;

import com.estsoft.hellospring.domain.Person;
import com.estsoft.hellospring.service.HiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

@RestController
public class HelloController {
    private HiService service;

    public HelloController(HiService service) {
        this.service = service;
    }
    @GetMapping("/hi") // GET localhost:8080/hi?name=queryparameter
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

        return String.format("Hello %s!", name);
    }

    // POST localhost:8080/hi
    @PostMapping("/hi")
    public String testPost(@RequestBody String value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //json -> java object
            Person person = objectMapper.readValue(value, Person.class);
            System.out.println("person = " + person);
        } catch(JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("value=" + value);
        return value;
    }
}