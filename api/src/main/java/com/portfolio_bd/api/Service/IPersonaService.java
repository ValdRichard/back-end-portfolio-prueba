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
    
    public EducacionDto addEducacionToPersona(Long id, Educacion educacion);
    
    public List<EducacionDto> getAllEducacionesFromPersona(Long personaId);
    
    public List<Educacion> deleteEducacionInPersona(Long personaId, Long educacionId);            
    
    public Persona createPersona(Persona persona);
    
    public PersonaDto updatePersona(Long id, PersonaDto personaDto);
    
    public PersonaDto getPersona(Long id);
}