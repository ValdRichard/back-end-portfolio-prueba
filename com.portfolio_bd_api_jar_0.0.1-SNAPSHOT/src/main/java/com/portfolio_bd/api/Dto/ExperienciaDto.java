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
public class ExperienciaDto {
    
    private Long id;
    private Long personaId;
    private String puestoExpe;
    private String periodoExpe;
    private String organismoExpe;
    private String descripcionExpe;
    private String urlLogoExpe;

    public ExperienciaDto() {
    }

    public ExperienciaDto(Long id, Long personaId, String puestoExpe, String periodoExpe, String organismoExpe, String descripcionExpe, String urlLogoExpe) {
        this.id = id;
        this.personaId = personaId;
        this.puestoExpe = puestoExpe;
        this.periodoExpe = periodoExpe;
        this.organismoExpe = organismoExpe;
        this.descripcionExpe = descripcionExpe;
        this.urlLogoExpe = urlLogoExpe;
    }
    
}
