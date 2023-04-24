/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author valdiviaricardo
 */

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;

    
    @Override
    public PersonaDto getPersona(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona not found"));
        return PersonaDto.fromEntity(persona);
    }

    @Transactional
    @Override
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public PersonaDto updatePersona(Long id, PersonaDto personaDto) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona not found with id " + id));

        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());

        List<Educacion> educaciones = persona.getEducaciones();
        educaciones.clear();
        educaciones.addAll(personaDto.getEducaciones().stream()
                .map(EducacionDto::toEntity)
                .collect(Collectors.toList()));

        personaRepository.save(persona);
        return PersonaDto.fromEntity(persona);
    }
    
    @Override
    public PersonaDto addEducacionToPersona(Long id, Educacion educacion) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona not found with id " + id));
        educacion.setPersona(persona);
        persona.agregarEducacion(educacion);
        personaRepository.save(persona);
        return PersonaDto.fromEntity(persona);
    }

    public void deleteEducacionInPersona(Long personaId, Long educacionId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona not found with id " + personaId));
        persona.deleteEducacion(educacionId);
        personaRepository.save(persona);
    }
    
    @Override
    public List<EducacionDto> getAllEducacionesFromPersona(Long personaId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona not found"));
        List<Educacion> educaciones = persona.getEducaciones();
        return educaciones.stream().map(EducacionDto::fromEntity).collect(Collectors.toList());
    }
    
}

