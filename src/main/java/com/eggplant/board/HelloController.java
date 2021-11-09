package com.eggplant.board;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/api/hi")
    public String hi() {
        return "index";
    }
}
