/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Service.IPersonaService;
import com.portfolio_bd.api.Service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valdiviaricardo
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {
    private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }
    
    @PostMapping("/create")
    public PersonaDto createPersona(@RequestBody PersonaDto personaDto) {
        Persona persona = PersonaDto.toEntity(personaDto);
        Persona personaCreated = personaService.createPersona(persona);
        return PersonaDto.fromEntity(personaCreated);
    }
    
    @GetMapping("/{id}")
    public PersonaDto getPersona(@PathVariable Long id) {
        PersonaDto personaDto = personaService.getPersona(id);
        return personaDto;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePersona(@PathVariable Long id, @RequestBody PersonaDto personaDto) {
        personaService.updatePersona(id, personaDto);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{id}/educaciones")
    public PersonaDto addEducacionToPersona(@PathVariable Long id, @RequestBody EducacionDto educacionDto) {
        Educacion educacion = EducacionDto.toEntity(educacionDto);
        return personaService.addEducacionToPersona(id, educacion);
    }

    @GetMapping("/{id}/educaciones")
    public List<EducacionDto> getAllEducacionesFromPersona(@PathVariable Long id) {
        List<EducacionDto> educacionesDto = personaService.getAllEducacionesFromPersona(id);
        return educacionesDto;
    }
    
}