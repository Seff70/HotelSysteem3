package com.capgemini.spring;

import com.capgemini.Model.Meer;
import com.capgemini.Model.Rivier;
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
