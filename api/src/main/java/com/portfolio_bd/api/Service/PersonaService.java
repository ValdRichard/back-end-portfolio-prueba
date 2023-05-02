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
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author valdiviaricardo
 */

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    
    @Transactional
    @Override
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }
    
    @Override
    @Transactional
    public PersonaDto updatePersona(Long id, PersonaDto personaDto) {
        Persona persona = personaRepository.getReferenceById(id);
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
    public EducacionDto addEducacionToPersona(Long id, Educacion educacion) {
        PersonaDto personaDto = PersonaDto.getInstance();
        educacion.setPersona(personaDto.toEntity());
        personaDto.addEducacion(EducacionDto.fromEntity(educacion));
        updatePersona(id, personaDto);
        return EducacionDto.fromEntity(educacion);
    }


    @Override
    public List<Educacion> deleteEducacionInPersona(Long personaId, Long educacionId) {
        Persona persona = Persona.getInstance();
        persona.deleteEducacion(educacionId);
        personaRepository.save(persona);
        return persona.getAllEducaciones();
    }

    @Override
    public List<EducacionDto> getAllEducacionesFromPersona(Long personaId) {
        Persona persona = Persona.getInstance();
        List<Educacion> educaciones = persona.getEducaciones();
        return educaciones.stream()
                .map(e -> EducacionDto.fromEntity(e))
                .collect(Collectors.toList());
    }
    
    @Override 
    public PersonaDto getPersona(Long id){
        Persona persona = personaRepository.getReferenceById(id);
        return PersonaDto.fromEntity(persona);
    }
}