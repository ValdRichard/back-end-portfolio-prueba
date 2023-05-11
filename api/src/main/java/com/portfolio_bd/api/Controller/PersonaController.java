/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        return personaService.createPersona(personaDto);
    }
    
    @GetMapping("/get")
    public PersonaDto getPersona() {
        PersonaDto personaDto = personaService.getPersona(1L);
        return personaDto;
    }
    
    @PutMapping("/update")
    public ResponseEntity<Void> updatePersona(@RequestBody PersonaDto personaDto) {
        personaService.updatePersona(personaDto);
        return ResponseEntity.ok().build();
    }
}