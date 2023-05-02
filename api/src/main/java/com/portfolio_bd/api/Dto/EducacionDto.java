/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

/**
 *
 * @author valdiviaricardo
 */
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducacionDto {
    private Long id;
    private String nivel;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
    private String urlLogoEdu;
    private PersonaDto persona;

    public EducacionDto(Educacion educacion){
        this.id = educacion.getId();
        this.nivel = educacion.getNivel();
        this.tituloEdu = educacion.getTituloEdu();
        this.periodoEdu = educacion.getPeriodoEdu();
        this.institucionEdu = educacion.getInstitucionEdu();
        this.descripcionEdu = educacion.getDescripcionEdu();
        this.urlLogoEdu = educacion.getUrlLogoEdu();
        this.persona = PersonaDto.getInstance();
    }
    
    
    public static EducacionDto fromEntity(Educacion educacion) {
        EducacionDto dto = new EducacionDto(educacion);
        return dto;
    }
    
    public static Educacion toEntity(EducacionDto educacionDto) {
        Educacion educacion = new Educacion();
        educacion.setId(educacionDto.getId());
        educacion.setNivel(educacionDto.getNivel());
        educacion.setTituloEdu(educacionDto.getTituloEdu());
        educacion.setPeriodoEdu(educacionDto.getPeriodoEdu());
        educacion.setInstitucionEdu(educacionDto.getInstitucionEdu());
        educacion.setDescripcionEdu(educacionDto.getDescripcionEdu());
        educacion.setUrlLogoEdu(educacionDto.getUrlLogoEdu());

        if (educacionDto.getPersona() != null) {
            educacion.setPersona(Persona.getInstance());
        }

        return educacion;
    }

    
    public void setPersona(PersonaDto persona) {
    this.persona = persona;
        persona.getEducaciones().add(this);
    }   
}