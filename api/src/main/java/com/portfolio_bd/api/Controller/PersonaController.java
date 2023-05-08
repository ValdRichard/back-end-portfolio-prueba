/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Mapper.EducacionMapper;
import com.portfolio_bd.api.Mapper.PersonaMapper;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Service.IPersonaService;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;

    @PostMapping("/create")
    public PersonaDto createPersona(@RequestBody PersonaDto personaDto) {
        Persona persona = Persona.getInstance();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setEducaciones(personaDto.getEducaciones().stream()
                .map(educacionDto -> EducacionMapper.toEntity(educacionDto, persona))
                .collect(Collectors.toList()));

        personaService.createPersona(persona);

        return PersonaMapper.fromEntity(persona);
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

    @GetMapping("/{id}/educaciones")
    public List<EducacionDto> getAllEducacionesFromPersona(@PathVariable Long id) {
        List<EducacionDto> educacionesDto = personaService.getAllEducacionesFromPersona(id);
        return educacionesDto;
    }
    
}