/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author valdiviaricardo
 */

@Setter
@Getter
public class PortfolioDto {
    private PersonaDto persona;
    private List<EducacionDto> educaciones;
    private List<ExperienciaDto> experiencias;
    private List<HardSkillDto> hardSkills;
    private List<SoftSkillDto> softSkills;
    private List<ProyectoDto> proyectos;
    
    public PortfolioDto(){
    }
}
