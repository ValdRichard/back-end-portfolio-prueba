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
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaDto getPersona(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona not found"));
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

    @Override
    public List<EducacionDto> getAllEducacionesFromPersona(Long personaId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona not found"));
        List<Educacion> educaciones = persona.getEducaciones();
        return educaciones.stream().map(EducacionDto::fromEntity).collect(Collectors.toList());
    }
    
    @Transactional
    @Override
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void updatePersona(Long id, PersonaDto personaDto) {
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
    }

}

//@Service
//public class PersonaService implements IPersonaService {
//
//    @Autowired public PersonaRepository repoPerso;
//    
//    private final Persona perso = Persona.getInstance();
//    
//    
//    @Override
//    public void crearPersona() {
//        perso.setNombre("Ricardo");
//        repoPerso.save(perso);
//    }
//    @Override
//    public boolean editarPersona(Long id, PersonaDto perso) {
//        if (Persona.getInstance()== null) {
//            return false;
//        } else {
//            Persona persoEditada = Persona.getInstance();
//            persoEditada.setNombre(perso.getNombre());
//            persoEditada.setOcupacion(perso.getOcupacion());
//            persoEditada.setBannerUrl(perso.getBannerUrl());
//            persoEditada.setEmail(perso.getEmail());
//            persoEditada.setLinkedinUrl(perso.getLinkedinUrl());
//            persoEditada.setGithubUrl(perso.getGithubUrl());
//            persoEditada.setDescripcion(perso.getDescripcion());
//            persoEditada.setImgUrl(perso.getImgUrl());
//            repoPerso.save(persoEditada);
//            return true;
//        }
//    }
//
//
//    
//}
