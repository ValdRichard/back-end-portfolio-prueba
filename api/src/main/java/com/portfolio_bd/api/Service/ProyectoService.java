/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.ProyectoDto;
import com.portfolio_bd.api.Mapper.ProyectoMapper;
import com.portfolio_bd.api.Model.Proyecto;
import com.portfolio_bd.api.Repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoRepository;
    
    @Autowired
    private ProyectoMapper mapper;
    
    @Override
    public ProyectoDto createProyecto(ProyectoDto proyectoDto) {
        Proyecto proyecto = proyectoRepository.save(mapper.proyectoDtoToProyecto(proyectoDto));
        return mapper.proyectoToProyectoDto(proyecto);
    }

    @Override
    public ResponseEntity<Void> deleteProyecto(Long proyectoId) {
        proyectoRepository.deleteById(proyectoId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ProyectoDto updateProyecto(Long proyectoId, ProyectoDto proyectoDto) {
        Proyecto proyecto = proyectoRepository.getReferenceById(proyectoId);
        proyectoRepository.save(mapper.updateProyectoFromDto(proyectoDto, proyecto));
        return mapper.proyectoToProyectoDto(proyecto);
    }

    @Override
    public ProyectoDto getProyecto(Long id) {
        return mapper.proyectoToProyectoDto(proyectoRepository.getReferenceById(id));
    }

    @Override
    public List<ProyectoDto> getAllProyectos() {
        return mapper.allProyectosToProyectosDto(proyectoRepository.findAll());
    }
}