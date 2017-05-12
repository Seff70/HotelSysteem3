package com.capgemini.repository;

import com.capgemini.Model.Boten.Trip;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Component;

/**
 * Created by gerard on 12-5-17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TripRelProvider implements RelProvider {

    @Override
    public String getItemResourceRelFor(Class<?> aClass) {
        return "trips";
    }

    @Override
    public String getCollectionResourceRelFor(Class<?> aClass) {
        return "trips";
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Trip.class.isAssignableFrom(aClass);
    }

}
