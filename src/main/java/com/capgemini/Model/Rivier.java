package com.capgemini.Model;

import javax.persistence.Entity;
import java.time.Duration;
import java.time.LocalDateTime;


@Entity
public class Rivier extends Trip {

    public Rivier() {
    }

    public Rivier(int tripID, LocalDateTime startTime, LocalDateTime endTime, int prijs) {
        super(tripID, startTime, endTime, prijs);
    }

    @Override
    public Duration getDuur() {
        Duration d = super.getDuur().minusMinutes(30);
        if (d.isNegative()) {
            return Duration.ZERO;
        } else {
            return d;
        }

    }

}
