package com.revature.developercorner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {

    @GetMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/index1")
    public String index1() {
        return "Greetings from Spring Boot!index1";
    }
}
