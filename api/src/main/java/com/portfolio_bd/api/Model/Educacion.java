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
public class Educacion{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
//    Para pruebas en postman:
//    {
//    "nivel":"NivelPrueba",
//    "tituloEdu":"TituloPrueba",
//    "periodoEdu":"PeriodoPrueba",
//    "institucionEdu":"InstitucionPrueba",
//    "descripcionEdu":"DescrpcionPrueba",
//    "urlLogoEdu":"LogoPrueba"
//    }
}