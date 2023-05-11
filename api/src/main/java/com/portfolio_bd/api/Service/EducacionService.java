/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;
import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Mapper.EducacionMapper;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
/**
 *
 * @author valdiviaricardo
 */
@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educacionRepository;
    
    @Autowired
    private EducacionMapper mapper;
    
    @Override
    public EducacionDto createEducacion(EducacionDto educacionDto) {
        Educacion educacion = educacionRepository.save(mapper.educacionDtoToEducacion(educacionDto));
        return mapper.educacionToEducacionDto(educacion);
    }

    @Override
    public ResponseEntity<Void> deleteEducacion(Long educacionId) {
        educacionRepository.deleteById(educacionId);
        return ResponseEntity.ok().build();
    }

    @Override
    public EducacionDto updateEducacion(Long educacionId, EducacionDto educacionDto) {
        Educacion educacion = educacionRepository.getReferenceById(educacionId);
        educacionRepository.save(mapper.updateEducacionFromDto(educacionDto, educacion));
        return mapper.educacionToEducacionDto(educacion);
    }

    @Override
    public EducacionDto getEducacion(Long id) {
        return mapper.educacionToEducacionDto(educacionRepository.getReferenceById(id));
    }

    @Override
    public List<EducacionDto> getAllEducaciones() {
        return mapper.allEducacionesToEducacionesDto(educacionRepository.findAll());
    }
}
