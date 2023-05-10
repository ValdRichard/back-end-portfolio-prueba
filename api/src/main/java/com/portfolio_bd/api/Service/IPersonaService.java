/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import java.util.List;

/**
 *
 * @author valdiviaricardo
 */
public interface IPersonaService {
    
    public PersonaDto createPersona(PersonaDto personaDto);
    
    public PersonaDto updatePersona(PersonaDto personaDto);
    
    public PersonaDto getPersona(Long id);
}