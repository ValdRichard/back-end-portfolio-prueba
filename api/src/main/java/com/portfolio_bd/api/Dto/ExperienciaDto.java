/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author valdiviaricardo
 */
@Setter
@Getter
public class ExperienciaDto {
    private Long id;
    private String nombrePuesto;
    private String nombreLugar;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinal;
}
