package com.capgemini.controller;

import com.capgemini.Model.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @RequestMapping(value = "/api/pages", method= RequestMethod.GET)
    public Page get() {
        Page page = new Page();
        page.setTitle("Kamer management");
        page.setContent("Vul hieronder het betrefffende kamernummer");
        return page;
    }

}
