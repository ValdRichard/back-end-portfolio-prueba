/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;

/**
 *
 * @author valdiviaricardo
 */

public class EducacionMapper {
    public static EducacionDto fromEntity(Educacion educacion, PersonaDto personaDto) {
        EducacionDto educacionDto = new EducacionDto(educacion);
        educacionDto.setPersona(personaDto);
        return educacionDto;
    }
    
    public static Educacion toEntity(EducacionDto educacionDto, Persona persona) {
        Educacion educacion = new Educacion();
        educacion.setNivel(educacionDto.getNivel());
        educacion.setTituloEdu(educacionDto.getTituloEdu());
        educacion.setPeriodoEdu(educacionDto.getPeriodoEdu());
        educacion.setInstitucionEdu(educacionDto.getInstitucionEdu());
        educacion.setDescripcionEdu(educacionDto.getDescripcionEdu());
        educacion.setUrlLogoEdu(educacionDto.getUrlLogoEdu());
        educacion.setPersona(persona);
        return educacion;
    }
}
