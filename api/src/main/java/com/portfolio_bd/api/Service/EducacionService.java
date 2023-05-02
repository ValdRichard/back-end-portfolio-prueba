/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;
import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
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
    private EducacionRepository educacionRepository;
    
    @Autowired 
    private PersonaRepository personaRepository;
    
    @Override
    public EducacionDto getEducacion(Long id) {
        Educacion educacion = educacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Educacion not found"));
        return EducacionDto.fromEntity(educacion);
    }
    @Override
    public Educacion createEducacion(Educacion educacion) {
        Persona persona = Persona.getInstance();
        
//        Educacion educacion = new Educacion();
//        educacion.setNivel(educacionDto.getNivel());
//        educacion.setTituloEdu(educacionDto.getTituloEdu());
//        educacion.setPeriodoEdu(educacionDto.getPeriodoEdu());
//        educacion.setInstitucionEdu(educacionDto.getInstitucionEdu());
//        educacion.setDescripcionEdu(educacionDto.getDescripcionEdu());
//        educacion.setUrlLogoEdu(educacionDto.getUrlLogoEdu());

        if (educacion.getPersona() != null) {
            educacion.setPersona(persona);
        }
        return educacionRepository.save(educacion);
    }
    
    @Override
    public void deleteEducacion(Long educacionId) {
        Educacion educacion = educacionRepository.findById(educacionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Educacion not found with id " + educacionId));
        Persona persona = educacion.getPersona();
        persona.deleteEducacion(educacionId);
        personaRepository.save(persona);
        educacionRepository.delete(educacion);
        PersonaDto personaDto = PersonaDto.getInstance();
        EducacionDto educacionDto = new EducacionDto(educacion);
        educacionDto.setPersona(personaDto);
        personaDto.removeEducacion(educacionId);
    }

    
    @Override
    public List<EducacionDto> getAllEducaciones() {
        List<Educacion> educaciones = educacionRepository.findAll();
        return educaciones.stream()
                          .map(EducacionDto::new)
                          .collect(Collectors.toList());
    }
    
    @Override
    public EducacionDto updateEducacion(Long educacionId, EducacionDto educacionDto) {
        Educacion educacion = educacionRepository.findById(educacionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona not found with id " + educacionId));

        educacion.setNivel(educacionDto.getNivel());
        educacion.setTituloEdu(educacionDto.getTituloEdu());
        educacion.setPeriodoEdu(educacionDto.getPeriodoEdu());
        educacion.setInstitucionEdu(educacionDto.getInstitucionEdu());
        educacion.setDescripcionEdu(educacionDto.getDescripcionEdu());
        educacion.setUrlLogoEdu(educacionDto.getUrlLogoEdu());

        educacionRepository.save(educacion);
        return EducacionDto.fromEntity(educacion);
    }
}
