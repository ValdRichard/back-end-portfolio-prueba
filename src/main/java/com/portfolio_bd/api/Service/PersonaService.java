/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class PersonaService implements IPersonaService {

    @Autowired public PersonaRepository repoPerso;

    @Override
    public boolean editarPersona(Long id, PersonaDto perso) {
        if (Persona.getInstance()== null) {
            return false;
        } else {
            Persona persoEditada = Persona.getInstance();
            persoEditada.setNombre(perso.getNombre());
            persoEditada.setOcupacion(perso.getOcupacion());
            persoEditada.setBannerUrl(perso.getBannerUrl());
            persoEditada.setEmail(perso.getEmail());
            persoEditada.setLinkedinUrl(perso.getLinkedinUrl());
            persoEditada.setGithubUrl(perso.getGithubUrl());
            persoEditada.setDescripcion(perso.getDescripcion());
            persoEditada.setImgUrl(perso.getImgUrl());
            repoPerso.save(persoEditada);
            return true;
        }
    }
}
