/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Mapper.PersonaMapper;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Model.PersonaPersis;
import com.portfolio_bd.api.Repository.PersonaPersisRepository;
import com.portfolio_bd.api.Repository.PersonaRepository;
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
    private PersonaPersisRepository personaPersisRepository;
    
    @Autowired
    private PersonaMapper mapper;
    
    @Transactional
    @Override
    public PersonaDto createPersona(PersonaDto personaDto) {
        Persona persona = personaRepository.save(mapper.personaDtoToPersona(personaDto));
        personaPersisRepository.save(mapper.personaToPersonaPersis(persona));
        return mapper.personaToPersonaDto(persona);
    }
    
    @Override
    public PersonaDto updatePersona(PersonaDto personaDto) {
        Persona persona = personaRepository.save(mapper.personaDtoToPersona(personaDto));
        personaPersisRepository.save(mapper.personaToPersonaPersis(persona));
        return mapper.personaToPersonaDto(persona);
    }
    
    @Override 
    public PersonaDto getPersona(Long id){
        PersonaPersis persona = personaPersisRepository.getReferenceById(id);
        return mapper.personaPersisToPersonaDto(persona);
    }
}