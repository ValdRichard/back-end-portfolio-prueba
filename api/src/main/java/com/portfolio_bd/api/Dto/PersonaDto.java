/*
 * Click nbfs: nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs: nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

/**
 *
 * @author valdiviaricardo
 */
import com.portfolio_bd.api.Model.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {
    private Long id;
    private String nombre;
    private String apellido;
//    private List<EducacionDto> educaciones = new ArrayList<>();
    
//    private static PersonaDto instance;
//
//    public static synchronized PersonaDto getInstance() {
//        if (instance == null) {
//            instance = new PersonaDto();
//        }
//        return instance;
//    }
    
//    
//    public void removeEducacion(Long educacionId) {
//        this.educaciones.removeIf(educacionDto -> educacionDto.getId().equals(educacionId));
//    }
//    
//    public void addEducacion(EducacionDto educacionDto){
//        this.educaciones.add(educacionDto);
//    }

}