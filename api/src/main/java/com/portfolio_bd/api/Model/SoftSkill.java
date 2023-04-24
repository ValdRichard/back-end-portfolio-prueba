/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Model;

/**
 *
 * @author valdiviaricardo
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class SoftSkill implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    private String nombreHabilidad;
    private String urlIcono;
    
   
    public SoftSkill() {
    }

    public SoftSkill(Persona persona, String nombreHabilidad, String urlIcono) {
        this.persona = persona;
        this.nombreHabilidad = nombreHabilidad;
        this.urlIcono = urlIcono;
    }    
}