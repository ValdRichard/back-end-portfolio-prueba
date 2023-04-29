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
import com.portfolio_bd.api.Service.IPersonaService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PersonaDto {
    private Long id;
    private String nombre;
    private String apellido;
    private List<EducacionDto> educaciones = new ArrayList<>();

    private static PersonaDto instance = null;

    private PersonaDto() {
    }

    private PersonaDto(Persona persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.educaciones = persona.getEducaciones();
    }

    public static PersonaDto getInstance() {
        if (instance == null) {
            instance = new PersonaDto();
        }
        return instance;
    }
    
    
    public void removeEducacion(Long educacionId) {
    educaciones.removeIf(educacionDto -> educacionDto.getId().equals(educacionId));
    }
//    
//    public static PersonaDto fromEntity(Persona persona, IPersonaService personaService) {
//        PersonaDto personaDto = PersonaDto.getInstance();
//        personaDto.setId(persona.getId());
//        personaDto.setNombre(persona.getNombre());
//        personaDto.setApellido(persona.getApellido());
//        
//        List<EducacionDto> educacionesDto = persona.getEducaciones().stream()
//            .map(e -> new EducacionDto(e, personaService))
//            .collect(Collectors.toList());
//        return personaDto;
//    }
//    
//    public Persona toEntity() {
//        Persona persona = Persona.getInstance();
//        persona.setId(this.id);
//        persona.setNombre(this.nombre);
//        persona.setApellido(this.apellido);
//
//        List<Educacion> educacionesP = this.educaciones.stream()
//                .map(EducacionDto::toEntity)
//                .collect(Collectors.toList());
//        educacionesP.forEach(educacion -> educacion.setPersona(persona));
//
//        persona.setEducaciones(educacionesP);
//        return persona;
//    }
    
    // Getters and setters
}