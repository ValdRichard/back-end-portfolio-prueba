/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.HardSkillDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author valdiviaricardo
 */
public interface IHardSkillService {
    
    public HardSkillDto createHardSkill(HardSkillDto hardSkillDto);
    
    public ResponseEntity<Void> deleteHardSkill(Long hardSkillId);
    
    public HardSkillDto updateHardSkill(Long hardSkillId, HardSkillDto hardSkillDto);
    
    public HardSkillDto getHardSkill(Long id);
            
    public List<HardSkillDto> getAllHardSkills();
}