/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.ExperienciaDto;

/**
 *
 * @author valdiviaricardo
 */

public interface IExperienciaService {
    
    public void crearExperiencia(ExperienciaDto expe);
       
    public boolean editarExperiencia(Long id, ExperienciaDto expe);
    
    public void borrarExperiencia(Long id);
}