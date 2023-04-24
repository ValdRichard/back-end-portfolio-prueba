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
public class Proyecto implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    private String nombreProye;
    private String descripcionProye;
    private String imgUrl;
    private String repoUrl;
    private String liveUrl;
    

    public Proyecto() {
    }

    public Proyecto(Persona persona, String nombreProye, String descripcionProye, String imgUrl, String repoUrl, String liveUrl) {
        this.persona = persona;
        this.nombreProye = nombreProye;
        this.descripcionProye = descripcionProye;
        this.imgUrl = imgUrl;
        this.repoUrl = repoUrl;
        this.liveUrl = liveUrl;
    }
}

