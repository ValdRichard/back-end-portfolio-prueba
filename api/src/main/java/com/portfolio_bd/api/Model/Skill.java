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
public class Skill{
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String porcentaje;
    private String nombreHabilidad;
//    Para pruebas en postman:
//    {
//    "nivelHabilidad":"nivelPrueba",
//    "nombreHabilidad":"nivelPrueba",
//    "urlIcono":"nivelPrueba"
//    }
}
