/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.HardSkillDto;
import com.portfolio_bd.api.Service.IHardSkillService;
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
@RequestMapping("/hardSkills")
public class HardSkillController {

    @Autowired
    private IHardSkillService hardSkillService;

   @PostMapping("/create")
    public HardSkillDto createHardSkill(@RequestBody HardSkillDto hardSkillDto) {
        return hardSkillService.createHardSkill(hardSkillDto);
    }
    
    @PutMapping("/{id}")
    public HardSkillDto updateHardSkill(@PathVariable Long id, @RequestBody HardSkillDto hardSkillDto) {
        return hardSkillService.updateHardSkill(id, hardSkillDto);
    }

    @DeleteMapping("/{hardSkillId}")
    public void deleteHardSkill(@PathVariable Long hardSkillId) {
        hardSkillService.deleteHardSkill(hardSkillId);
    }
    
    @GetMapping("/getAll")
    public List<HardSkillDto> getAll() {
        return hardSkillService.getAllHardSkills();
    }
        
    @GetMapping("/{id}")
    public HardSkillDto getById(@PathVariable Long id) {
        return hardSkillService.getHardSkill(id);
    }
}