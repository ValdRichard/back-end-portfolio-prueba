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
import com.portfolio_bd.api.Service.IPersonaService;
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

    private static PersonaDto instance = null;

    private PersonaDto() {
    }

    private PersonaDto(Long id, String nombre, String apellido, List<EducacionDto> educaciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.educaciones = educaciones;
    }

    public static PersonaDto getInstance() {
        if (instance == null) {
            instance = new PersonaDto();
        }
        return instance;
    }
    
    public static PersonaDto fromEntity(Persona persona, IPersonaService personaService) {
        List<EducacionDto> educacionesDto = persona.getEducaciones().stream()
            .map(e -> new EducacionDto(e, personaService))
            .collect(Collectors.toList());

        return new PersonaDto(persona.getId(), persona.getNombre(), persona.getApellido(), educacionesDto);
    }
    public Persona toEntity() {
        Persona persona = Persona.;
        persona.setId(id);
        persona.setNombre(nombre);
        persona.setApellido(apellido);

        List<Educacion> educaciones = this.educaciones.stream()
                .map(EducacionDto::toEntity)
                .collect(Collectors.toList());
        educaciones.forEach(educacion -> educacion.setPersona(persona));

        persona.setEducaciones(educaciones);
        return persona;
    }

    // Constructor that takes an IPersonaService as a parameter
    public PersonaDto(Long id, String nombre, String apellido, List<EducacionDto> educaciones, IPersonaService personaService) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.educaciones = educaciones;
    }
    
    
    public void removeEducacion(Long educacionId) {
    educaciones.removeIf(educacionDto -> educacionDto.getId().equals(educacionId));
    }
    // Getters and setters
}