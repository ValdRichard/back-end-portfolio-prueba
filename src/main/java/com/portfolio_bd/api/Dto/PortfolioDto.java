/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

/**
 *
 * @author valdiviaricardo
 */
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class PortfolioDto {
    
    private PersonaDto persona;    
    private List<EducacionDto> educaciones;   
    private List<ExperienciaDto> experiencias;   
    private List<HardSkillDto> habTecnicas;   
    private List<SoftSkillDto> habBlandas;
    private List<ProyectoDto> proyectos;

    public PortfolioDto() {
    }

    public PortfolioDto(PersonaDto persona, List<EducacionDto> educaciones, List<ExperienciaDto> experiencias, List<HardSkillDto> habTecnicas, List<SoftSkillDto> habBlandas, List<ProyectoDto> proyectos) {
        this.persona = persona;
        this.educaciones = educaciones;
        this.experiencias = experiencias;
        this.habTecnicas = habTecnicas;
        this.habBlandas = habBlandas;
        this.proyectos = proyectos;
    } 
}