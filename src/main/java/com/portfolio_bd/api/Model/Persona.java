/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Model;

/**
 *
 * @author valdiviaricardo
 */
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Persona {
    
    private static Persona INSTANCE;
    
    @Id
    private Long id;
    private String nombre;
    private String ocupacion;
    private String bannerUrl;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String descripcion;
    private String imgUrl;
    
    @OneToMany(mappedBy = "persona")
    private List<Educacion> educaciones;

    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "persona")
    private List<HardSkill> habTecnicas;

    @OneToMany(mappedBy = "persona")
    private List<SoftSkill> habBlandas;

    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyectos;
    
    

    private Persona(){        
        this.id = 1L;
    }
    
    public static Persona getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Persona();
        }
        
        return INSTANCE;
    }

}