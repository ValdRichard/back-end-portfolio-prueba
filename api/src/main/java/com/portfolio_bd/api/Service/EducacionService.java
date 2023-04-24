/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;
import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Repository.EducacionRepository;
import com.portfolio_bd.api.Repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
/**
 *
 * @author valdiviaricardo
 */
@Service
public class EducacionService implements IEducacionService{
    @Autowired
    private final EducacionRepository educacionRepository;
    
    public EducacionService(EducacionRepository educacionRepository) {
        this.educacionRepository = educacionRepository;
    }
    
    @Override
    public Educacion createEducacion(EducacionDto educacionDto, Persona persona) {
        Educacion educacion = new Educacion();
        educacion.setTituloEdu(educacionDto.getTituloEdu());
        educacion.setInstitucionEdu(educacionDto.getInstitucionEdu());
        educacion.setPersona(persona);
        return educacionRepository.save(educacion);
    }
    
    @Override
    public void deleteEducacion(Long educacionId) {
        educacionRepository.deleteById(educacionId);
    }
    
    @Override
    public List<EducacionDto> getAllEducaciones() {
        List<Educacion> educaciones = educacionRepository.findAll();
        return educaciones.stream()
                          .map(EducacionDto::new)
                          .collect(Collectors.toList());
    }
    
    public EducacionDto updateEducacion(Long educacionId, EducacionDto educacionDto) {
        Educacion educacion = educacionRepository.findById(educacionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona not found with id " + educacionId));

        educacion.setNivel(educacionDto.getNivel());
        educacion.setTituloEdu(educacionDto.getTituloEdu());
        educacion.setPeriodoEdu(educacionDto.getPeriodoEdu());
        educacion.setInstitucionEdu(educacionDto.getInstitucionEdu());
        educacion.setDescripcionEdu(educacionDto.getDescripcionEdu());
        educacion.setUrlLogoEdu(educacionDto.getUrlLogoEdu());

        Educacion updatedEducacion = educacionRepository.save(educacion);
        return EducacionDto.fromEntity(updatedEducacion);
    }
}
