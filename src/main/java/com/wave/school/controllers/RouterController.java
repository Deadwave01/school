package com.wave.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {


    @GetMapping("/")
    public String mainPage(){
        return "main";
    }


}
