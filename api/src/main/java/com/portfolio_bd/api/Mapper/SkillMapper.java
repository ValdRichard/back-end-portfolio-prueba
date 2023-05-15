/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.SkillDto;
import com.portfolio_bd.api.Model.Skill;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 *
 * @author valdiviaricardo
 */
@Mapper(componentModel = "spring")
public interface SkillMapper {
    @Mapping(target = "id", ignore = true)
    Skill skillDtoToSkill(SkillDto Skill);
    
    SkillDto skillToSkillDto(Skill Skill);
    
    @Mapping(target = "id", ignore = true)
    Skill updateSkillFromDto(SkillDto skillDto, @MappingTarget Skill skill);
    
    List<SkillDto> allSkillsToSkillsDto(List<Skill> skills);
}