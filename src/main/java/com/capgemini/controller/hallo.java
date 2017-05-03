package com.capgemini.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hallo {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String homes(){return
            ("Hello world");}

}
