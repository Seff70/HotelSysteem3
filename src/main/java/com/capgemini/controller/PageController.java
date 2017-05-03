package com.capgemini.controller;

import com.capgemini.Model.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @RequestMapping(value = "/api/page", method= RequestMethod.GET)
    public Page get() {
        Page page = new Page();
        page.setTitle("titel");
        page.setContent("dit is de content");
        return page;
    }

}
