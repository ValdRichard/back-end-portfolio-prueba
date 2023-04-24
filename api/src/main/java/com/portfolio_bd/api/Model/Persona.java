/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Model;

/**
 *
 * @author valdiviaricardo
 */
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Persona {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String apellido;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educacion> educaciones = new ArrayList<>();

    @Builder
    public Persona(String nombre, String apellido, String fechaNacimiento, List<Educacion> educaciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.educaciones = educaciones != null ? educaciones : new ArrayList<>();
    }

    public void agregarEducacion(Educacion educacion) {
        educaciones.add(educacion);
    }

    public Educacion obtenerEducacion(int indice) {
        return educaciones.get(indice);
    }
    
    public List<Educacion> getAllEducaciones() {
        return this.educaciones;
    }
    
    public Long getId() {
        return id;
    }
}
//Aplicado de patron "Singleton"
//
//@Entity
//@Setter @Getter
//public class Persona {
//    
//    private static Persona INSTANCE;
//    
//    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
//    private String nombre;
//    private String ocupacion;
//    private String bannerUrl;
//    private String email;
//    private String linkedinUrl;
//    private String githubUrl;
//    private String descripcion;
//    private String imgUrl;
//    
//    @OneToMany(mappedBy = "persona")
//    private List<Educacion> educaciones = new ArrayList<>();
//
//    @OneToMany(mappedBy = "persona")
//    private List<Experiencia> experiencias = new ArrayList<>(); ;
//    
//    @OneToMany(mappedBy = "persona")
//    private List<HardSkill> habTecnicas = new ArrayList<>();;
//
//    @OneToMany(mappedBy = "persona")
//    private List<SoftSkill> habBlandas = new ArrayList<>();;
//
//    @OneToMany(mappedBy = "persona")
//    private List<Proyecto> proyectos = new ArrayList<>();;
//    
//    
//
//    private Persona(){        
//    }
//    
//    public static Persona getInstance(){
//        if(INSTANCE == null){
//            INSTANCE = new Persona();
//        }
//        
//        return INSTANCE;
//    }
//
//}