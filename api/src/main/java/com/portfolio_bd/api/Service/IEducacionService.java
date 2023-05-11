/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author valdiviaricardo
 */
public interface IEducacionService {
    
    public EducacionDto createEducacion(EducacionDto educacionDto);
    
    public ResponseEntity<Void> deleteEducacion(Long educacionId);
    
    public EducacionDto updateEducacion(Long educacionId, EducacionDto educacionDto);
    
    public EducacionDto getEducacion(Long id);
            
    public List<EducacionDto> getAllEducaciones();
}