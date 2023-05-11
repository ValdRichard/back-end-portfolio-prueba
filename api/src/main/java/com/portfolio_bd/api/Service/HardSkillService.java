/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.HardSkillDto;
import com.portfolio_bd.api.Mapper.HardSkillMapper;
import com.portfolio_bd.api.Model.HardSkill;
import com.portfolio_bd.api.Repository.HardSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class HardSkillService implements IHardSkillService{
    
    @Autowired
    private HardSkillRepository hardSkillRepository;
    
    @Autowired
    private HardSkillMapper mapper;
    
    @Override
    public HardSkillDto createHardSkill(HardSkillDto hardSkillDto) {
        HardSkill hardSkill = hardSkillRepository.save(mapper.hardSkillDtoToHardSkill(hardSkillDto));
        return mapper.hardSkillToHardSkillDto(hardSkill);
    }

    @Override
    public ResponseEntity<Void> deleteHardSkill(Long hardSkillId) {
        hardSkillRepository.deleteById(hardSkillId);
        return ResponseEntity.ok().build();
    }

    @Override
    public HardSkillDto updateHardSkill(Long hardSkillId, HardSkillDto hardSkillDto) {
        HardSkill hardSkill = hardSkillRepository.getReferenceById(hardSkillId);
        hardSkillRepository.save(mapper.updateHardSkillFromDto(hardSkillDto, hardSkill));
        return mapper.hardSkillToHardSkillDto(hardSkill);
    }

    @Override
    public HardSkillDto getHardSkill(Long id) {
        return mapper.hardSkillToHardSkillDto(hardSkillRepository.getReferenceById(id));
    }

    @Override
    public List<HardSkillDto> getAllHardSkills() {
        return mapper.allHardSkillsToHardSkillsDto(hardSkillRepository.findAll());
    }
}