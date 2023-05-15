/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Service.IEducacionService;
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
@RequestMapping("api/educaciones")
public class EducacionController {

    @Autowired
    private IEducacionService educacionService;

   @PostMapping("/create")
    public EducacionDto createEducacion(@RequestBody EducacionDto educacionDto) {
        return educacionService.createEducacion(educacionDto);
    }
    
    @PutMapping("/{id}")
    public EducacionDto updateEducacion(@PathVariable Long id, @RequestBody EducacionDto educacionDto) {
        return educacionService.updateEducacion(id, educacionDto);
    }

    @DeleteMapping("/{educacionId}")
    public void deleteEducacion(@PathVariable Long educacionId) {
        educacionService.deleteEducacion(educacionId);
    }
    
    @GetMapping("/getAll")
    public List<EducacionDto> getAll() {
        return educacionService.getAllEducaciones();
    }
        
    @GetMapping("/{id}")
    public EducacionDto getById(@PathVariable Long id) {
        return educacionService.getEducacion(id);
    }
}