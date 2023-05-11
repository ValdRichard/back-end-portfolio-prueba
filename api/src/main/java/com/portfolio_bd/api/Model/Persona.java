/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Model;

/**
 *
 * @author valdiviaricardo
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String imageBanner;
    private String imageFotoPerfil;
    private String imageInstagram;
    private String imageLinkedin;
    private String urlInstagram;
    private String urlLinkedin;
    private String mail;
    private String nombreyApellido;
    private static Persona instance;

    public static synchronized Persona getInstance() {
        if (instance == null) {
            instance = new Persona();
        }
        return instance;
    }

    private Persona() {
    } 
    
//    Para pruebas en postman: 
//    {
//        "nombre":"Ricardo",
//        "apellido":"Valdivia",
//    }
}
