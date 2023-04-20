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
public class ProyectoDto {
    
    private Long id;
    private Long personaId;
    private String nombreProye;
    private String descripcionProye;
    private String imgUrl;
    private String repoUrl;
    private String liveUrl;

    public ProyectoDto() {
    }

    public ProyectoDto(Long id, Long personaId, String nombreProye, String descripcionProye, String imgUrl, String repoUrl, String liveUrl) {
        this.id = id;
        this.personaId = personaId;
        this.nombreProye = nombreProye;
        this.descripcionProye = descripcionProye;
        this.imgUrl = imgUrl;
        this.repoUrl = repoUrl;
        this.liveUrl = liveUrl;
    }    
}