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
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nivel;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
    private String urlLogoEdu;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
    
    public Educacion(){
        
    }
    // constructors, getters, and setters
}