package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.ProyectoDto;
import com.portfolio_bd.api.Model.Proyecto;
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
public class ProyectoMapperImpl implements ProyectoMapper {

    @Override
    public Proyecto proyectoDtoToProyecto(ProyectoDto proyecto) {
        if ( proyecto == null ) {
            return null;
        }

        Proyecto proyecto1 = new Proyecto();

        proyecto1.setNombreProyecto( proyecto.getNombreProyecto() );
        proyecto1.setDescripcionProyecto( proyecto.getDescripcionProyecto() );
        proyecto1.setRepoUrl( proyecto.getRepoUrl() );

        return proyecto1;
    }

    @Override
    public ProyectoDto proyectoToProyectoDto(Proyecto proyecto) {
        if ( proyecto == null ) {
            return null;
        }

        ProyectoDto proyectoDto = new ProyectoDto();

        proyectoDto.setId( proyecto.getId() );
        proyectoDto.setNombreProyecto( proyecto.getNombreProyecto() );
        proyectoDto.setDescripcionProyecto( proyecto.getDescripcionProyecto() );
        proyectoDto.setRepoUrl( proyecto.getRepoUrl() );

        return proyectoDto;
    }

    @Override
    public Proyecto updateProyectoFromDto(ProyectoDto ProyectoDto, Proyecto proyecto) {
        if ( ProyectoDto == null ) {
            return proyecto;
        }

        proyecto.setNombreProyecto( ProyectoDto.getNombreProyecto() );
        proyecto.setDescripcionProyecto( ProyectoDto.getDescripcionProyecto() );
        proyecto.setRepoUrl( ProyectoDto.getRepoUrl() );

        return proyecto;
    }

    @Override
    public List<ProyectoDto> allProyectosToProyectosDto(List<Proyecto> proyectos) {
        if ( proyectos == null ) {
            return null;
        }

        List<ProyectoDto> list = new ArrayList<ProyectoDto>( proyectos.size() );
        for ( Proyecto proyecto : proyectos ) {
            list.add( proyectoToProyectoDto( proyecto ) );
        }

        return list;
    }
}
