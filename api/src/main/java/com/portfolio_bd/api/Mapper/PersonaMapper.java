/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author valdiviaricardo
 */
@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDto personaToPersonaDto(Persona persona);
    
    Persona personaDtoToPersona(PersonaDto personaDto);
    
    EducacionDto educacionToEducacionDto(Educacion educacion);
    
    Educacion educacionDtoToEducacion(EducacionDto educacion);
    
    List<Educacion> allEducacionesToEducacionesDto(List<Educacion> educaciones);
    
    List<EducacionDto> allEducacionesDtoToEducaciones(List<EducacionDto> educacionesDto);
    
    default Persona getPersonaInstance() {
        return Persona.getInstance();
    }
    
    
    
    default List<Educacion> getEducacionesFromPersona() {
        return getPersonaInstance().getEducaciones();
    }
    
    default void addEducacionToPersona(Educacion educacion) {
        getPersonaInstance().addEducacion(educacion);
    }
}
