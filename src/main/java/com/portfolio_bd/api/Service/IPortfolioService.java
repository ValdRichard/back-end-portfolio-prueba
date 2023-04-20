/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.ExperienciaDto;
import com.portfolio_bd.api.Dto.HardSkillDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Dto.PortfolioDto;
import com.portfolio_bd.api.Dto.ProyectoDto;
import com.portfolio_bd.api.Dto.SoftSkillDto;
import com.portfolio_bd.api.Model.Persona;
import java.util.List;

/**
 *
 * @author valdiviaricardo
 */

public interface IPortfolioService {
    
    
    public Persona getPersona();
    
    //Modificar persona
    public boolean editarPersona(PersonaDto perso);
    
    public PersonaDto getPersonaDto();
    
    public List<EducacionDto> listarEducacionDto();
    
    public List<ExperienciaDto> listarExperienciaDto();
    
    public List<HardSkillDto> listarHardSkillDto();
    
    public List<SoftSkillDto> listarSoftSkillDto();
    
    public List<ProyectoDto> listarProyectoDto();
   
    public PortfolioDto getPortfolio();
    
}