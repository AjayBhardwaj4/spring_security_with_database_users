package com.project.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public String greet() {
        return "Hello World!!";
    }

    @GetMapping("/qa")
    public String qa() {
        return "This is qa";
    }

    @GetMapping("/dev")
    public String dev() {
        return "This is developer";
    }

    @GetMapping("/accessserver")
    public String accessServer() {
        return "Accessing the server";
    }

    @GetMapping("/home")
    public String home() {
        return "Accessing the home";
    }
}
