package com.example.project.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Welcome {

    // localhost:8082/clinique
   @GetMapping("")
    public String say_helo(){
        return  "Hello, I am a rest controller";
    }

}
