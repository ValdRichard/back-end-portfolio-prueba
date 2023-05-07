/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author valdiviaricardo
 */
public class PersonaMapper {
    public static PersonaDto fromEntity(Persona persona) {
        PersonaDto personaDto = PersonaDto.getInstance();
        personaDto.setId(persona.getId());
        personaDto.setNombre(persona.getNombre());
        personaDto.setApellido(persona.getApellido());
         
        if (persona.getEducaciones() != null) {
        List<EducacionDto> educaciones = persona.getEducaciones().stream()
                .map(EducacionMapper::fromEntity)
                .collect(Collectors.toList());
                personaDto.setEducaciones(educaciones);
        }
         return personaDto;
    }
     
    public Persona toEntity(PersonaDto personaDto) {
         Persona persona = Persona.getInstance();
         persona.setNombre(personaDto.getNombre());
         persona.setApellido(personaDto.getApellido());
 
         List<Educacion> educacionesP = personaDto.getEducaciones().stream()
                 .map(EducacionMapper::toEntity)
                 .collect(Collectors.toList());
         educacionesP.forEach(educacion -> educacion.setPersona(persona));
 
         persona.setEducaciones(educacionesP);
         return persona;
    }
}
