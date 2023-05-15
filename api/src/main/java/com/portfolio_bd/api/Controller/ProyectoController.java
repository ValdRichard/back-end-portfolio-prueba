/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.ProyectoDto;
import com.portfolio_bd.api.Service.IProyectoService;
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
@RequestMapping("api/proyectos")
public class ProyectoController {

    @Autowired
    private IProyectoService proyectoService;

   @PostMapping("/create")
    public ProyectoDto createProyecto(@RequestBody ProyectoDto proyectoDto) {
        return proyectoService.createProyecto(proyectoDto);
    }
    
    @PutMapping("/{id}")
    public ProyectoDto updateProyecto(@PathVariable Long id, @RequestBody ProyectoDto proyectoDto) {
        return proyectoService.updateProyecto(id, proyectoDto);
    }

    @DeleteMapping("/{proyectoId}")
    public void deleteProyecto(@PathVariable Long proyectoId) {
        proyectoService.deleteProyecto(proyectoId);
    }
    
    @GetMapping("/getAll")
    public List<ProyectoDto> getAll() {
        return proyectoService.getAllProyectos();
    }
        
    @GetMapping("/{id}")
    public ProyectoDto getById(@PathVariable Long id) {
        return proyectoService.getProyecto(id);
    }
}