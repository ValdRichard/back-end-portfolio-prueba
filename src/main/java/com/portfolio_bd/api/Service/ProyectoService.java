/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.ProyectoDto;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Model.Proyecto;
import com.portfolio_bd.api.Repository.PersonaRepository;
import com.portfolio_bd.api.Repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class ProyectoService implements IProyectoService {

    @Autowired public ProyectoRepository repoProye;
    @Autowired public PersonaRepository repoPerso;
    
    @Override
    public void crearProyecto(ProyectoDto proye) {
        Persona perso = repoPerso.findById(proye.getPersonaId()).orElse(null);
        Proyecto nuevoProye = new Proyecto(perso, proye.getNombreProye(), proye.getDescripcionProye(), proye.getImgUrl(), proye.getRepoUrl(), proye.getLiveUrl());
        repoProye.save(nuevoProye);
    }

    @Override
    public boolean editarProyecto(Long id, ProyectoDto proye) {
        if (!repoProye.existsById(id)) {
            return false;
        } else {
            Proyecto proyeEditado = repoProye.findById(id).orElse(null);
            proyeEditado.setPersona(repoPerso.findById(proye.getPersonaId()).orElse(null));
            proyeEditado.setNombreProye(proye.getNombreProye());
            proyeEditado.setDescripcionProye(proye.getDescripcionProye());
            proyeEditado.setImgUrl(proye.getImgUrl());
            proyeEditado.setRepoUrl(proye.getRepoUrl());
            proyeEditado.setLiveUrl(proye.getLiveUrl());
            repoProye.save(proyeEditado);
            return true;
        }
    }

    @Override
    public void borrarProyecto(Long id) {
        repoProye.deleteById(id);
    }    
}