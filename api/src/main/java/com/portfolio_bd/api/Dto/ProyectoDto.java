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
public class ProyectoDto {
    private Long id;
    private String nombreProyecto;
    private String descripcionProyecto;
    private String repoUrl;
}
