/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Mapper.EducacionMapper;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Service.EducacionService;
import com.portfolio_bd.api.Service.IEducacionService;
import com.portfolio_bd.api.Service.IPersonaService;
import com.portfolio_bd.api.Service.PersonaService;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valdiviaricardo
 */
@RestController
@RequestMapping("/educaciones")
public class EducacionController {

    @Autowired
    private IEducacionService educacionService;

    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/getAll")
    public List<EducacionDto> getAll() {
        return educacionService.getAllEducaciones();
    }

   @PostMapping("/create")
    public EducacionDto createEducacion(@RequestBody EducacionDto educacionDto) {
        Educacion educacion = EducacionMapper.toEntity(educacionDto);
        educacionService.createEducacion(educacion);
        personaService.addEducacionToPersona(1L, educacion);
        return EducacionMapper.fromEntity(educacion);
    }
    
    @GetMapping("/{id}")
    public EducacionDto getById(@PathVariable Long id) {
        return educacionService.getEducacion(id);
    }

    @PutMapping("/{id}")
    public EducacionDto updateEducacion(@PathVariable Long id, @RequestBody EducacionDto educacionDto) {
        return educacionService.updateEducacion(id, educacionDto);
    }

    @DeleteMapping("/{educacionId}")
    public void deleteEducacion(@PathVariable Long educacionId) {
        educacionService.deleteEducacion(educacionId);
    }
}