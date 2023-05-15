package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.SkillDto;
import com.portfolio_bd.api.Model.Skill;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T20:01:57-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
*/
@Component
public class SkillMapperImpl implements SkillMapper {

    @Override
    public Skill skillDtoToSkill(SkillDto Skill) {
        if ( Skill == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setPorcentaje( Skill.getPorcentaje() );
        skill.setNombreHabilidad( Skill.getNombreHabilidad() );

        return skill;
    }

    @Override
    public SkillDto skillToSkillDto(Skill Skill) {
        if ( Skill == null ) {
            return null;
        }

        SkillDto skillDto = new SkillDto();

        skillDto.setId( Skill.getId() );
        skillDto.setPorcentaje( Skill.getPorcentaje() );
        skillDto.setNombreHabilidad( Skill.getNombreHabilidad() );

        return skillDto;
    }

    @Override
    public Skill updateSkillFromDto(SkillDto skillDto, Skill skill) {
        if ( skillDto == null ) {
            return skill;
        }

        skill.setPorcentaje( skillDto.getPorcentaje() );
        skill.setNombreHabilidad( skillDto.getNombreHabilidad() );

        return skill;
    }

    @Override
    public List<SkillDto> allSkillsToSkillsDto(List<Skill> skills) {
        if ( skills == null ) {
            return null;
        }

        List<SkillDto> list = new ArrayList<SkillDto>( skills.size() );
        for ( Skill skill : skills ) {
            list.add( skillToSkillDto( skill ) );
        }

        return list;
    }
}
