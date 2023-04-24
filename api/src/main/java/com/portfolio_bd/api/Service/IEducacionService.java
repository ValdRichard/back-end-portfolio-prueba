/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Model.Educacion;
import java.util.List;

/**
 *
 * @author valdiviaricardo
 */
public interface IEducacionService {
    
    public EducacionDto getEducacion(Long id);
            
    List<EducacionDto> getAllEducaciones();
    
    public Educacion createEducacion(EducacionDto educacionDto, Long personaId);
    
    public void deleteEducacion(Long educacionId);
    
    public EducacionDto updateEducacion(Long educacionId, EducacionDto educacionDto);
}