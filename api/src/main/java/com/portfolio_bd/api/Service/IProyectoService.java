/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.ProyectoDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author valdiviaricardo
 */
public interface IProyectoService {
    public ProyectoDto createProyecto(ProyectoDto proyectoDto);
    
    public ResponseEntity<Void> deleteProyecto(Long proyectoId);
    
    public ProyectoDto updateProyecto(Long proyectoId, ProyectoDto proyectoDto);
    
    public ProyectoDto getProyecto(Long id);
            
    public List<ProyectoDto> getAllProyectos();
}
