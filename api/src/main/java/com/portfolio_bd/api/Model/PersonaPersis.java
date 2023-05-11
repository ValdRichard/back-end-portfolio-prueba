/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author valdiviaricardo
 */
@Setter
@Getter
@Entity
public class PersonaPersis {
    @Id
    private Long id;
    private String imageBanner;
    private String imageFotoPerfil;
    private String imageInstagram;
    private String imageLinkedin;
    private String urlInstagram;
    private String urlLinkedin;
    private String mail;
    private String nombreyApellido;
    
    public PersonaPersis(){
    }
}