package org.example.controller;

import org.example.repository.StudentJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    // J2ME => mobile edition => android
    // J2SE => 지금 우리가 사용중인 java
    // J2EE => WEB 기반의 java version
    @Autowired
    private StudentJdbcRepository studentJdbcRepository;

    @GetMapping("/hello")
    public int hi() {
        return studentJdbcRepository.countOfStudent();
    }

    @GetMapping("/hello/name/list")
    public List<String> getName() {
        return studentJdbcRepository.getStudentNameList();
    }

    @PostMapping("/hello/name/regist")
    public int saveStudent(@RequestParam String name, @RequestParam Integer age) {
        return studentJdbcRepository.insertStudent(name, age);
    }
}
