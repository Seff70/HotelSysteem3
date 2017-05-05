package com.capgemini.controller;
import com.capgemini.Model.Boten.Boot;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@RestController
public class BootController {

    @RequestMapping(value = "/api/boot", method= RequestMethod.GET )
    public ArrayList<Boot> boot (){
        ArrayList<Boot> botenList = new ArrayList<>();
        for (int i = 0; i < 8 ; i++) {
            Boot boot = new Boot(i,"Naam van de boot" +i);
            botenList.add(boot);
        }
        return botenList ;

    }


}
