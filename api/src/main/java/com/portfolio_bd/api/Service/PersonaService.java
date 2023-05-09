/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Mapper.EducacionMapper;
import com.portfolio_bd.api.Mapper.PersonaMapper;
import com.portfolio_bd.api.Mapper.PersonaMapping;
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

    @Autowired
    private PersonaMapper mapper;
    
    @Transactional
    @Override
    public PersonaDto createPersona(PersonaDto personaDto) {
        Persona persona = personaRepository.save(mapper.personaDtoToPersona(personaDto));
        return mapper.personaToPersonaDto(persona);
    }
    
    @Override
    public Persona updatePersona(Long id, PersonaDto personaDto) {
        Persona persona = personaRepository.getReferenceById(id);
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        return personaRepository.save(persona);
    }
    
    @Override
    public PersonaDto addEducacionToPersona(Educacion educacion) {
        Persona persona = Persona.getInstance();
        persona.addEducacion(educacion);
        personaRepository.save(persona);
        return PersonaMapping.fromEntity(persona);
    }


    @Override
    public List<Educacion> deleteEducacionInPersona(Long personaId, Long educacionId) {
        Persona persona = Persona.getInstance();
        persona.deleteEducacion(educacionId);
        personaRepository.save(persona);
        return persona.getAllEducaciones();
    }
//
//    @Override
//    public List<EducacionDto> getAllEducacionesFromPersona(Long personaId) {
//        Persona persona = Persona.getInstance();
//        List<Educacion> educaciones = persona.getEducaciones();
//        return educaciones.stream()
//                .map(e -> EducacionMapper.fromEntity(e))
//                .collect(Collectors.toList());
//    }
    
    @Override 
    public PersonaDto getPersona(Long id){
        Persona persona = personaRepository.getReferenceById(id);
        return mapper.personaToPersonaDto(persona);
    }
}