package com.capgemini.controller;

import com.capgemini.Model.Page;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class PageController {

    @RequestMapping(value = "/api/page", method= RequestMethod.GET)
    public Page get() {
        Page page = new Page();
        page.setContent("This is our Content");
        page.setTitle("Dit is onze title");

        return page;
    }

}
