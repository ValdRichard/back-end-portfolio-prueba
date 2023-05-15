/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.SkillDto;
import com.portfolio_bd.api.Service.ISkillService;
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
@RequestMapping("api/skills")
public class SkillController {

    @Autowired
    private ISkillService skillService;

   @PostMapping("/create")
    public SkillDto createSkill(@RequestBody SkillDto skillDto) {
        return skillService.createSkill(skillDto);
    }
    
    @PutMapping("/{id}")
    public SkillDto updateSkill(@PathVariable Long id, @RequestBody SkillDto skillDto) {
        return skillService.updateSkill(id, skillDto);
    }

    @DeleteMapping("/{skillId}")
    public void deleteSkill(@PathVariable Long skillId) {
        skillService.deleteSkill(skillId);
    }
    
    @GetMapping("/getAll")
    public List<SkillDto> getAll() {
        return skillService.getAllSkills();
    }
        
    @GetMapping("/{id}")
    public SkillDto getById(@PathVariable Long id) {
        return skillService.getSkill(id);
    }
}