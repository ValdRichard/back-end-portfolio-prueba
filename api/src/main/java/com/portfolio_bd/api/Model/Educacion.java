/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Model;

/**
 *
 * @author valdiviaricardo
 */
import com.portfolio_bd.api.Dto.PersonaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nivel;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
    private String urlLogoEdu;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private PersonaDto persona;

    public Educacion(){
    }

    public Educacion(Long id, String nivel, String tituloEdu, String periodoEdu, String institucionEdu, 
                     String descripcionEdu, String urlLogoEdu, PersonaDto persona) {
        this.id = id;
        this.nivel = nivel;
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.institucionEdu = institucionEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlLogoEdu = urlLogoEdu;
        this.persona = persona;
    }
}
