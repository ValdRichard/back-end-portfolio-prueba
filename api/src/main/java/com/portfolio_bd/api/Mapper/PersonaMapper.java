/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Model.PersonaPersis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author valdiviaricardo
 */
@Mapper(componentModel = "spring")
public interface PersonaMapper {
    @Mapping(target="id", ignore = true)
    Persona personaDtoToPersona(PersonaDto personaDto);
    
    PersonaPersis personaToPersonaPersis(Persona persona);
    
    PersonaDto personaToPersonaDto(Persona persona);
    
    PersonaDto personaPersisToPersonaDto(PersonaPersis personaPersis);
            
    default Persona getPersonaInstance() {
      return Persona.getInstance();
    }
}
