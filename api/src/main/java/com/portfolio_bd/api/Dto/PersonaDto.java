/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

/**
 *
 * @author valdiviaricardo
 */
import com.portfolio_bd.api.Model.Persona;
import java.util.ArrayList;
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

    public PersonaDto() {}

    
    public PersonaDto(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
     
    public PersonaDto(Persona persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.educaciones = persona.getEducaciones().stream()
                                .map(EducacionDto::new)
                                .collect(Collectors.toList());
    }

    public static Persona toEntity(PersonaDto personaDto) {
        return Persona.builder()
            .nombre(personaDto.getNombre())
            .apellido(personaDto.getApellido())
            .educaciones(personaDto.getEducaciones().stream()
                    .map(EducacionDto::toEntity)
                    .collect(Collectors.toList()))
            .build();
    }
    

    public static PersonaDto fromEntity(Persona persona) {
        PersonaDto dto = new PersonaDto();
        dto.setId(persona.getId());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        List<EducacionDto> educacionDtos = persona.getEducaciones().stream()
                .map(EducacionDto::fromEntity)
                .collect(Collectors.toList());
        dto.setEducaciones(educacionDtos);
        return dto;
    }
    // getters and setters
}