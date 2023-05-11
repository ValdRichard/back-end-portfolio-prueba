/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.SoftSkillDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author valdiviaricardo
 */
public interface ISoftSkillService {
    public SoftSkillDto createSoftSkill(SoftSkillDto softSkillDto);
    
    public ResponseEntity<Void> deleteSoftSkill(Long softSkillId);
    
    public SoftSkillDto updateSoftSkill(Long softSkillId, SoftSkillDto softSkillDto);
    
    public SoftSkillDto getSoftSkill(Long id);
            
    public List<SoftSkillDto> getAllSoftSkills();
}
