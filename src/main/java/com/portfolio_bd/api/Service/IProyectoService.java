/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.ProyectoDto;

/**
 *
 * @author valdiviaricardo
 */

public interface IProyectoService {
    
    public void crearProyecto(ProyectoDto proyecto);
    
    public boolean editarProyecto(Long id, ProyectoDto proyecto);
    
    public void borrarProyecto(Long id);
    
}