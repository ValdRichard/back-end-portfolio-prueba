package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.ExperienciaDto;
import com.portfolio_bd.api.Model.Experiencia;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T20:01:58-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
*/
@Component
public class ExperienciaMapperImpl implements ExperienciaMapper {

    @Override
    public Experiencia experienciaDtoToExperiencia(ExperienciaDto experiencia) {
        if ( experiencia == null ) {
            return null;
        }

        Experiencia experiencia1 = new Experiencia();

        experiencia1.setNombrePuesto( experiencia.getNombrePuesto() );
        experiencia1.setNombreLugar( experiencia.getNombreLugar() );
        experiencia1.setDescripcion( experiencia.getDescripcion() );
        experiencia1.setFechaInicio( experiencia.getFechaInicio() );
        experiencia1.setFechaFinal( experiencia.getFechaFinal() );

        return experiencia1;
    }

    @Override
    public ExperienciaDto experienciaToExperienciaDto(Experiencia experiencia) {
        if ( experiencia == null ) {
            return null;
        }

        ExperienciaDto experienciaDto = new ExperienciaDto();

        experienciaDto.setId( experiencia.getId() );
        experienciaDto.setNombrePuesto( experiencia.getNombrePuesto() );
        experienciaDto.setNombreLugar( experiencia.getNombreLugar() );
        experienciaDto.setDescripcion( experiencia.getDescripcion() );
        experienciaDto.setFechaInicio( experiencia.getFechaInicio() );
        experienciaDto.setFechaFinal( experiencia.getFechaFinal() );

        return experienciaDto;
    }

    @Override
    public Experiencia updateExperienciaFromDto(ExperienciaDto ExperienciaDto, Experiencia experiencia) {
        if ( ExperienciaDto == null ) {
            return experiencia;
        }

        experiencia.setNombrePuesto( ExperienciaDto.getNombrePuesto() );
        experiencia.setNombreLugar( ExperienciaDto.getNombreLugar() );
        experiencia.setDescripcion( ExperienciaDto.getDescripcion() );
        experiencia.setFechaInicio( ExperienciaDto.getFechaInicio() );
        experiencia.setFechaFinal( ExperienciaDto.getFechaFinal() );

        return experiencia;
    }

    @Override
    public List<ExperienciaDto> allExperienciasToExperienciasDto(List<Experiencia> experiencias) {
        if ( experiencias == null ) {
            return null;
        }

        List<ExperienciaDto> list = new ArrayList<ExperienciaDto>( experiencias.size() );
        for ( Experiencia experiencia : experiencias ) {
            list.add( experienciaToExperienciaDto( experiencia ) );
        }

        return list;
    }
}
