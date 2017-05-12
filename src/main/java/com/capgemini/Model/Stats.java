package com.capgemini.Model;

import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Boten.Trip;
import com.capgemini.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Created by diveldhu on 11-5-2017.
 */


public class Stats{

    @Autowired
    TripRepository tripRepository;

    public ArrayList<String> stats(){
        ArrayList<String> stats=new ArrayList<>();
        int numberOfTrips=0;
        int numberOfLakeTrips=0;
        int numberOfRiverTrips=0;
        Duration totalDurationOfTrips=Duration.ZERO;
        Duration totalDurationOfLakeTrips=Duration.ZERO;
        Duration totalDurationOfRiverTrips=Duration.ZERO;


        for(Trip trip:tripRepository.findAll()){
            System.out.println("duur van trip "+durationToString(trip.getDuur()));
            if(trip.getEndTime()!=null){
                numberOfTrips++;
                totalDurationOfTrips=totalDurationOfTrips.plus(trip.getDuur());
                System.out.println("total duration is nu: "+durationToString(totalDurationOfTrips));
                if(trip instanceof Rivier){
                    numberOfRiverTrips++;
                    totalDurationOfRiverTrips=totalDurationOfRiverTrips.plus(trip.getDuur());
                }else{
                    numberOfLakeTrips++;
                    totalDurationOfLakeTrips=totalDurationOfLakeTrips.plus(trip.getDuur());
                }
            }
        }

        stats.add("Totaal aantal tochten is "+numberOfTrips);
        stats.add("Aantal tochten over het meer is "+numberOfLakeTrips);
        stats.add("Aantal tochten over de rivier is "+numberOfRiverTrips);
        stats.add("Gemiddelde duur van een tocht is "+durationToString(totalDurationOfTrips.dividedBy(numberOfTrips)));
        stats.add("Gemiddelde duur van een tocht over het meer is "+durationToString(totalDurationOfLakeTrips.dividedBy(numberOfLakeTrips)));
        stats.add("Gemiddelde duur van een tocht over de rivier is "+durationToString(totalDurationOfRiverTrips.dividedBy(numberOfRiverTrips)));
        //System.out.println(durationToString(totalDurationOfTrips) + " / " + numberOfTrips + " = "+ durationToString(totalDurationOfTrips.dividedBy(numberOfTrips)));
        return stats;
        }

    private String durationToString(Duration duration){
        long seconds=duration.getSeconds();
        long absSeconds=Math.abs(seconds);
        String positive=String.format(
        "%d:%02d:%02d",
        absSeconds/3600,
        (absSeconds%3600)/60,
        absSeconds%60);
        //System.out.println(positive);
        return seconds< 0?"-"+positive:positive;
    }
}