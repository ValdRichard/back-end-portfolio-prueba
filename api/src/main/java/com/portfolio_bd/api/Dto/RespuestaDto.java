/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

/**
 *
 * @author valdiviaricardo
 */

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RespuestaDto {
    
    private boolean salioBien = true;
    private String msj = "";
       

    public RespuestaDto() {
    }

    public RespuestaDto(boolean salioBien, String msj) {
        this.salioBien = salioBien;
        this.msj = msj;
    }
       
}