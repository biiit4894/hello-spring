package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // J2ME => mobile edition => android
    // J2SE => 지금 우리가 사용중인 java
    // J2EE => WEB 기반의 java version
    @GetMapping("/hello")
    public String hi() {
        return "Hello";
    }
}
