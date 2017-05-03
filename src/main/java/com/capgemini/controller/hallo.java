package com.capgemini.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hallo {

    @RequestMapping("/html")
    public String homes(){return
            ("Hello world");}

}
