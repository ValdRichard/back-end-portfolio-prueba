/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 *
 * @author valdiviaricardo
 */

@Configuration
public class CorsConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/login")
                        .allowedOrigins("/**")
                        .allowedMethods("*")
                        .exposedHeaders("*");
                
                registry.addMapping("/api/**")
                        .allowedOrigins("/**")
                        .allowedMethods("*");
            }
        };
    }
    
}
