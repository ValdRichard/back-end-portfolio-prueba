/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;

/**
 *
 * @author valdiviaricardo
 */
public interface IEducacionService {

    public void crearEducacion(EducacionDto edu);
    
    public boolean editarEducacion(Long id, EducacionDto edu);
    
    public void borrarEducacion(Long id);
}