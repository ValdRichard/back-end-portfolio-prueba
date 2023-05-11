/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.HardSkillDto;
import com.portfolio_bd.api.Model.HardSkill;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 *
 * @author valdiviaricardo
 */
@Mapper(componentModel = "spring")
public interface HardSkillMapper {
    @Mapping(target = "id", ignore = true)
    HardSkill hardSkillDtoToHardSkill(HardSkillDto hardSkill);
    
    HardSkillDto hardSkillToHardSkillDto(HardSkill hardSkill);
    
    @Mapping(target = "id", ignore = true)
    HardSkill updateHardSkillFromDto(HardSkillDto HardSkillDto, @MappingTarget HardSkill hardSkill);
    
    List<HardSkillDto> allHardSkillsToHardSkillsDto(List<HardSkill> hardSkills);
}