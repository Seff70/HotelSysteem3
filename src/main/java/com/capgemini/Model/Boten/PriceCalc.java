package com.capgemini.Model.Boten;

import com.capgemini.controller.BoatController;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by lmanna on 18-5-2017.
 */

// tijdsindicaties ochtend / middag / namiddag
// temperatuursindicaties <20 / 20 - 25 / >25
// prijsindicaties
//      basis start 6e per 30 minuten bij 20 graden
//      warm 8e per 30 minuten bij 20 - 25 graden
//      hot 10e per 30 minuten bij 25 graden of meer

public class PriceCalc{

    private int temp;
    private Duration duur;


    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public PriceCalc() {

    }


    public Integer berekenPrijs(int temp, LocalTime start, LocalTime end, Duration duur) {
        // fields voor startprijzen
        int basis = 6;
        int warm = 8;
        int hot = 10;

        // tijd van eindigen (now) vergelijken met een dagdeel (limit)
        // als now later is dan limit, dan is isLate true
        LocalTime now = LocalTime.now();
        LocalTime limit =  LocalTime.of(11, 59);

        // het aantal uur tussen start en eind willen we gebruiken om te rekenen
        Duration verschil = Duration.between(now, limit);
        long verschil2 = verschil.toHours();
        Boolean isLate = now.isAfter( limit );
        int verschil3 = (int) verschil2;

        // field om de totaalprijzen te berekenen
        int totalBasis = basis + (verschil3 * 2);
        int totalWarm = warm + (verschil3 * 4);
        int totalHot = hot + (verschil3 * 8);

        // Scanner om de gebruiker om userinput te vragen
        // input via html & javascript?
        Scanner temperatuur = new Scanner(System.in);
        System.out.println("wat is uw temp?");
        String tempinput = temperatuur.nextLine();
        Integer tempToString = Integer.parseInt(tempinput);

        // Vergelijken van temperaturen en vervolgens output geven
        if (tempToString < 20) {
            // field om de temp later te vergelijken
            System.out.println("its colder than 20 degrees");
            System.out.println("uw totaalprijs is " + totalBasis);
        } else if (tempToString < 25) {
            System.out.println("its between 20-25 degrees");
            System.out.println("uw totaalprijs is " + totalWarm);
        } else if (tempToString > 25) {
            System.out.println("its hotter than 25 degrees");
            System.out.println("uw totaalprijs is " + totalHot);
        }

        return totalBasis;
    }
}




