/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.SoftSkillDto;
import com.portfolio_bd.api.Service.ISoftSkillService;
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
@RequestMapping("/softSkills")
public class SoftSkillController {

    @Autowired
    private ISoftSkillService softSkillService;

   @PostMapping("/create")
    public SoftSkillDto createSoftSkill(@RequestBody SoftSkillDto softSkillDto) {
        return softSkillService.createSoftSkill(softSkillDto);
    }
    
    @PutMapping("/{id}")
    public SoftSkillDto updateSoftSkill(@PathVariable Long id, @RequestBody SoftSkillDto softSkillDto) {
        return softSkillService.updateSoftSkill(id, softSkillDto);
    }

    @DeleteMapping("/{softSkillId}")
    public void deleteSoftSkill(@PathVariable Long softSkillId) {
        softSkillService.deleteSoftSkill(softSkillId);
    }
    
    @GetMapping("/getAll")
    public List<SoftSkillDto> getAll() {
        return softSkillService.getAllSoftSkills();
    }
        
    @GetMapping("/{id}")
    public SoftSkillDto getById(@PathVariable Long id) {
        return softSkillService.getSoftSkill(id);
    }
}