/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.SoftSkillDto;
import com.portfolio_bd.api.Mapper.SoftSkillMapper;
import com.portfolio_bd.api.Model.SoftSkill;
import com.portfolio_bd.api.Repository.SoftSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class SoftSkillService implements ISoftSkillService{
    
    @Autowired
    private SoftSkillRepository softSkillRepository;
    
    @Autowired
    private SoftSkillMapper mapper;
    
    @Override
    public SoftSkillDto createSoftSkill(SoftSkillDto softSkillDto) {
        SoftSkill softSkill = softSkillRepository.save(mapper.softSkillDtoToSoftSkill(softSkillDto));
        return mapper.softSkillToSoftSkillDto(softSkill);
    }

    @Override
    public ResponseEntity<Void> deleteSoftSkill(Long softSkillId) {
        softSkillRepository.deleteById(softSkillId);
        return ResponseEntity.ok().build();
    }

    @Override
    public SoftSkillDto updateSoftSkill(Long softSkillId, SoftSkillDto softSkillDto) {
        SoftSkill softSkill = softSkillRepository.getReferenceById(softSkillId);
        softSkillRepository.save(mapper.updateSoftSkillFromDto(softSkillDto, softSkill));
        return mapper.softSkillToSoftSkillDto(softSkill);
    }

    @Override
    public SoftSkillDto getSoftSkill(Long id) {
        return mapper.softSkillToSoftSkillDto(softSkillRepository.getReferenceById(id));
    }

    @Override
    public List<SoftSkillDto> getAllSoftSkills() {
        return mapper.allSoftSkillsToSoftSkillsDto(softSkillRepository.findAll());
    }
}