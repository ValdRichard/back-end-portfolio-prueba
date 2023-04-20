/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.HardSkillDto;
import com.portfolio_bd.api.Model.HardSkill;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Repository.HardSkillRepository;
import com.portfolio_bd.api.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class HardSkillService implements IHardSkillService {

    @Autowired public HardSkillRepository repoHabTecnica;
    @Autowired public PersonaRepository repoPerso;

    @Override
    public void crearHardSkill(HardSkillDto habTecnica) {
        Persona perso = repoPerso.findById(habTecnica.getPersonaId()).orElse(null);
        HardSkill nuevaHabTecnica = new HardSkill(perso, habTecnica.getNivelHard(),habTecnica.getNombreHabilidad(), habTecnica.getUrlIcono());
        repoHabTecnica.save(nuevaHabTecnica);
    }             
                
    @Override
    public boolean editarHardSkill(Long id, HardSkillDto habTecnica) {
        if (!repoHabTecnica.existsById(id)) {
            return false;
        } else {
            HardSkill HabTecnicaEditada = repoHabTecnica.findById(id).orElse(null);
            HabTecnicaEditada.setPersona(repoPerso.findById(habTecnica.getPersonaId()).orElse(null));
            HabTecnicaEditada.setNombreHabilidad(habTecnica.getNombreHabilidad());
            HabTecnicaEditada.setUrlIcono(habTecnica.getUrlIcono());
            repoHabTecnica.save(HabTecnicaEditada);
            return true;
        }
    }

    @Override
    public void borrarHardSkill(Long id) {
        repoHabTecnica.deleteById(id);
    }
    
}