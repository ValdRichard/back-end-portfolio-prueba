/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.SoftSkillDto;
import com.portfolio_bd.api.Model.SoftSkill;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 *
 * @author valdiviaricardo
 */
@Mapper(componentModel = "spring")
public interface SoftSkillMapper {
    @Mapping(target = "id", ignore = true)
    SoftSkill softSkillDtoToSoftSkill(SoftSkillDto softSkill);
    
    SoftSkillDto softSkillToSoftSkillDto(SoftSkill softSkill);
    
    @Mapping(target = "id", ignore = true)
    SoftSkill updateSoftSkillFromDto(SoftSkillDto SoftSkillDto, @MappingTarget SoftSkill softSkill);
    
    List<SoftSkillDto> allSoftSkillsToSoftSkillsDto(List<SoftSkill> softSkills);
}