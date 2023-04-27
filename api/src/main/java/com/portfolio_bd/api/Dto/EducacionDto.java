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
import com.portfolio_bd.api.Service.IPersonaService;
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

    public EducacionDto(Educacion educacion, IPersonaService personaService) {
        this.id = educacion.getId();
        this.nivel = educacion.getNivel();
        this.tituloEdu = educacion.getTituloEdu();
        this.periodoEdu = educacion.getPeriodoEdu();
        this.institucionEdu = educacion.getInstitucionEdu();
        this.descripcionEdu = educacion.getDescripcionEdu();
        this.urlLogoEdu = educacion.getUrlLogoEdu();
        if (educacion.getPersona() != null) {
            this.persona = PersonaDto.fromEntity(educacion.getPersona(), personaService);
        }
    }
    
    public static EducacionDto fromEntity(Educacion educacion, IPersonaService personaService) {
        EducacionDto dto = new EducacionDto(educacion, personaService);
        dto.setId(educacion.getId());
        dto.setNivel(educacion.getNivel());
        dto.setTituloEdu(educacion.getTituloEdu());
        dto.setPeriodoEdu(educacion.getPeriodoEdu());
        dto.setInstitucionEdu(educacion.getInstitucionEdu());
        dto.setDescripcionEdu(educacion.getDescripcionEdu());
        dto.setUrlLogoEdu(educacion.getUrlLogoEdu());
        return dto;
    }
    
    public static Educacion toEntity(EducacionDto educacionDto, IPersonaService personaService) {
        Educacion educacion = new Educacion();
        educacion.setId(educacionDto.getId());
        educacion.setNivel(educacionDto.getNivel());
        educacion.setTituloEdu(educacionDto.getTituloEdu());
        educacion.setPeriodoEdu(educacionDto.getPeriodoEdu());
        educacion.setInstitucionEdu(educacionDto.getInstitucionEdu());
        educacion.setDescripcionEdu(educacionDto.getDescripcionEdu());
        educacion.setUrlLogoEdu(educacionDto.getUrlLogoEdu());

        if (educacionDto.getPersona() != null) {
            PersonaDto personaDto = PersonaDto.fromEntity(personaService.getPersona(educacionDto.getPersona().getId()), personaService);
            educacion.setPersona(personaDto);
        }

        return educacion;
    }

    
    public void setPersona(PersonaDto persona) {
    this.persona = persona;
        persona.getEducaciones().add(this);
    }
    
}
//@Setter @Getter
//public class EducacionDto {
//    
//    private Long id;
//    private Long personaId;
//    private String tituloEdu;
//    private String periodoEdu;
//    private String institucionEdu;
//    private String descripcionEdu;
//    private String urlLogoEdu;
//
//    public EducacionDto() {
//    }
//
//    public EducacionDto(Long id, Long personaId, String tituloEdu, String periodoEdu, String institucionEdu, String descripcionEdu, String urlLogoEdu) {
//        this.id = id;
//        this.personaId = personaId;
//        this.tituloEdu = tituloEdu;
//        this.periodoEdu = periodoEdu;
//        this.institucionEdu = institucionEdu;
//        this.descripcionEdu = descripcionEdu;
//        this.urlLogoEdu = urlLogoEdu;
//    }
//}