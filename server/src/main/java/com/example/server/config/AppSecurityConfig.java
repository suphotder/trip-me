package com.example.server.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
