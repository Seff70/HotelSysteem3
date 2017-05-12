package com.capgemini.Model.Boten;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@DiscriminatorColumn(name = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(Meer.class),
        @JsonSubTypes.Type(Rivier.class)
})
public abstract class Trip {

    @Id
    @GeneratedValue
    private int tripID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public int getTripID() {
        return tripID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean start() {
        if (startTime == null) {
            startTime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

    public boolean stop() {
        if (endTime == null) {
            endTime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

    @JsonProperty
    public Duration getDuur() {
        if (startTime != null && endTime != null) {
            return Duration.between(startTime, endTime);
        } else {
            return Duration.ZERO;
        }
    }
}
