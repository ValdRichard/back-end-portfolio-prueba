/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.ExperienciaDto;
import com.portfolio_bd.api.Model.Experiencia;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Repository.ExperienciaRepository;
import com.portfolio_bd.api.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class ExperienciaService implements IExperienciaService {
    
    @Autowired public ExperienciaRepository repoExpe;
    @Autowired public PersonaRepository repoPerso;

    
    @Override
    public void crearExperiencia(ExperienciaDto expe) {
        Persona perso = repoPerso.findById(expe.getPersonaId()).orElse(null);
        Experiencia nuevaExpe = new Experiencia(perso, expe.getPuestoExpe(), expe.getPeriodoExpe(), expe.getOrganismoExpe(), expe.getDescripcionExpe(), expe.getUrlLogoExpe());
        repoExpe.save(nuevaExpe);
    }

    @Override
    public boolean editarExperiencia(Long id, ExperienciaDto expe) {
        if (!repoExpe.existsById(id)) {
            return false;
        } else {
            Experiencia expeEditada = repoExpe.findById(id).orElse(null);
            expeEditada.setPersona(repoPerso.findById(expe.getPersonaId()).orElse(null));
            expeEditada.setPuestoExpe(expe.getPuestoExpe());
            expeEditada.setPeriodoExpe(expe.getPeriodoExpe());
            expeEditada.setOrganismoExpe(expe.getOrganismoExpe());
            expeEditada.setDescripcionExpe(expe.getDescripcionExpe());
            expeEditada.setUrlLogoExpe(expe.getUrlLogoExpe());
            repoExpe.save(expeEditada);
            return true;
        }
    }

    @Override
    public void borrarExperiencia(Long id) {
        repoExpe.deleteById(id);
    }
    
    
}