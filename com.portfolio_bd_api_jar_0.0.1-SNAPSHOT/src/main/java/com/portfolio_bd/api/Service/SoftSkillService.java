/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.SoftSkillDto;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Model.SoftSkill;
import com.portfolio_bd.api.Repository.PersonaRepository;
import com.portfolio_bd.api.Repository.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class SoftSkillService implements ISoftSkillService {

    @Autowired public SoftSkillRepository repoHabBlanda;
    @Autowired public PersonaRepository repoPerso;

    @Override
    public void crearSoftSkill(SoftSkillDto habBlanda) {
        Persona perso = repoPerso.findById(habBlanda.getPersonaId()).orElse(null);
        SoftSkill nuevaHabBlanda = new SoftSkill(perso, habBlanda.getNombreHabilidad(), habBlanda.getUrlIcono());
        repoHabBlanda.save(nuevaHabBlanda);
    }

    @Override
    public boolean editarSoftSkill(Long id, SoftSkillDto habBlanda) {
        if (repoHabBlanda.existsById(id)) {
            SoftSkill habBlandaEditada = repoHabBlanda.findById(id).orElse(null);
            habBlandaEditada.setPersona(repoPerso.findById(habBlanda.getPersonaId()).orElse(null));
            habBlandaEditada.setNombreHabilidad(habBlanda.getNombreHabilidad());
            habBlandaEditada.setUrlIcono(habBlanda.getUrlIcono());
            repoHabBlanda.save(habBlandaEditada);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void borrarSoftSkill(Long id) {
        repoHabBlanda.deleteById(id);
    }
}
