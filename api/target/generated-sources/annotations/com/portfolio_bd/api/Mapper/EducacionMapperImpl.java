package com.portfolio_bd.api.Mapper;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Model.Educacion;
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
public class EducacionMapperImpl implements EducacionMapper {

    @Override
    public Educacion educacionDtoToEducacion(EducacionDto educacion) {
        if ( educacion == null ) {
            return null;
        }

        Educacion educacion1 = new Educacion();

        educacion1.setTituloEdu( educacion.getTituloEdu() );
        educacion1.setPeriodoEdu( educacion.getPeriodoEdu() );
        educacion1.setInstitucionEdu( educacion.getInstitucionEdu() );
        educacion1.setDescripcionEdu( educacion.getDescripcionEdu() );

        return educacion1;
    }

    @Override
    public EducacionDto educacionToEducacionDto(Educacion educacion) {
        if ( educacion == null ) {
            return null;
        }

        EducacionDto educacionDto = new EducacionDto();

        educacionDto.setId( educacion.getId() );
        educacionDto.setTituloEdu( educacion.getTituloEdu() );
        educacionDto.setPeriodoEdu( educacion.getPeriodoEdu() );
        educacionDto.setInstitucionEdu( educacion.getInstitucionEdu() );
        educacionDto.setDescripcionEdu( educacion.getDescripcionEdu() );

        return educacionDto;
    }

    @Override
    public Educacion updateEducacionFromDto(EducacionDto educacionDto, Educacion educacion) {
        if ( educacionDto == null ) {
            return educacion;
        }

        educacion.setTituloEdu( educacionDto.getTituloEdu() );
        educacion.setPeriodoEdu( educacionDto.getPeriodoEdu() );
        educacion.setInstitucionEdu( educacionDto.getInstitucionEdu() );
        educacion.setDescripcionEdu( educacionDto.getDescripcionEdu() );

        return educacion;
    }

    @Override
    public List<EducacionDto> allEducacionesToEducacionesDto(List<Educacion> educaciones) {
        if ( educaciones == null ) {
            return null;
        }

        List<EducacionDto> list = new ArrayList<EducacionDto>( educaciones.size() );
        for ( Educacion educacion : educaciones ) {
            list.add( educacionToEducacionDto( educacion ) );
        }

        return list;
    }
}
