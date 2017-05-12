package com.capgemini.spring;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Boten.Boat;
import com.capgemini.Model.Boten.Meer;
import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by gerard on 11-5-17.
 */
@Configuration
public class HotelRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Meer.class);
        config.exposeIdsFor(Rivier.class);
    }
}
