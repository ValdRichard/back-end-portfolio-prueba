/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("api/persona")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;

    @PostMapping("/create")
    public PersonaDto createProyecto(@RequestBody PersonaDto personaDto) {
        return personaService.createPersona(personaDto);
    }
    
    @PutMapping("/{id}")
    public PersonaDto updatePersona(@PathVariable Long id, @RequestBody PersonaDto personaDto) {
        return personaService.updatePersona(id, personaDto);
    }

    @DeleteMapping("/{personaId}")
    public void deletePersona(@PathVariable Long personaId) {
        personaService.deletePersona(personaId);
    }
    
    @GetMapping("/getAll")
    public List<PersonaDto> getAll() {
        return personaService.getAllPersonas();
    }
        
    @GetMapping("/{id}")
    public PersonaDto getById(@PathVariable Long id) {
        return personaService.getPersona(id);
    }
}