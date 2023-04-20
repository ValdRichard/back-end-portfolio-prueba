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
public class SoftSkillDto {
    
    private Long id;
    private Long personaId;
    private String nombreHabilidad;
    private String urlIcono;

    public SoftSkillDto() {
    }

    public SoftSkillDto(Long id, Long personaId, String nombreHabilidad, String urlIcono) {
        this.id = id;
        this.personaId = personaId;
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
    }
}
