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
//@Entity
//@Setter @Getter
//public class Educacion implements Serializable {
//
//    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "persona_id")
//    private Persona persona;
//    private String tituloEdu;
//    private String periodoEdu;
//    private String institucionEdu;
//    private String descripcionEdu;
//    private String urlLogoEdu;
//    
//
//    public Educacion() {
//    }
//
//    public Educacion(Persona persona, String tituloEdu, String periodoEdu, String institucionEdu, String descripcionEdu, String urlLogoEdu) {
//        this.persona = persona;
//        this.tituloEdu = tituloEdu;
//        this.periodoEdu = periodoEdu;
//        this.institucionEdu = institucionEdu;
//        this.descripcionEdu = descripcionEdu;
//        this.urlLogoEdu = urlLogoEdu;
//    }

