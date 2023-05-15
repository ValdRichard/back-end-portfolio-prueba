/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.ExperienciaDto;
import com.portfolio_bd.api.Service.IExperienciaService;
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
@RequestMapping("api/experiencias")
public class ExperienciaController {

    @Autowired
    private IExperienciaService experienciaService;

   @PostMapping("/create")
    public ExperienciaDto createExperiencia(@RequestBody ExperienciaDto experienciaDto) {
        return experienciaService.createExperiencia(experienciaDto);
    }
    
    @PutMapping("/{id}")
    public ExperienciaDto updateExperiencia(@PathVariable Long id, @RequestBody ExperienciaDto experienciaDto) {
        return experienciaService.updateExperiencia(id, experienciaDto);
    }

    @DeleteMapping("/{experienciaId}")
    public void deleteExperiencia(@PathVariable Long experienciaId) {
        experienciaService.deleteExperiencia(experienciaId);
    }
    
    @GetMapping("/getAll")
    public List<ExperienciaDto> getAll() {
        return experienciaService.getAllExperiencias();
    }
        
    @GetMapping("/{id}")
    public ExperienciaDto getById(@PathVariable Long id) {
        return experienciaService.getExperiencia(id);
    }
}