/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.SkillDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author valdiviaricardo
 */
public interface ISkillService {
    
    public SkillDto createSkill(SkillDto skillDto);
    
    public ResponseEntity<Void> deleteSkill(Long skillId);
    
    public SkillDto updateSkill(Long skillId, SkillDto skillDto);
    
    public SkillDto getSkill(Long id);
            
    public List<SkillDto> getAllSkills();
}