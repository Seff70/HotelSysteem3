package com.capgemini.controller;

import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Kamer;
import com.capgemini.Model.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PageController {

    @RequestMapping(value = "/api/pages", method= RequestMethod.GET)
    public Page get() {
        Page page = new Page();
        page.setTitle("Kamer management");
        page.setContent("Vul hieronder het betrefffende kamernummer");
        return page;
    }

    @RequestMapping(value="/api/kamernummer", method=RequestMethod.POST)
    public Kamer post(@RequestBody Kamer input) {
        ArrayList<Kamer> kamerList = new ArrayList<>(  );
        for (int i = 0; i<10; i++) {
            Kamer k = new Kamer();
            if (i< 5) {
                k.settype( Etype.standaard );
            }
            else {
                k.settype( Etype.luxe );
            }
                kamerList.add( k );
        }

        int kamernummer = input.getKamernummer();
        return kamerList.get(kamernummer);

    }

}