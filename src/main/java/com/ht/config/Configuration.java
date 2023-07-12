package com.ht.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author PragayanshuShukla
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
