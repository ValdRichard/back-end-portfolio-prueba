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
import java.util.Iterator;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educacion> educaciones = new ArrayList<>();

    private static Persona instance;

    private Persona(String nombre, String apellido, List<Educacion> educaciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.educaciones = educaciones != null ? educaciones : new ArrayList<>();
    }

    public static Persona getInstance() {
        if (instance == null) {
            instance = new Persona(null, null, null);
        }
        return instance;
    }

    public void agregarEducacion(Educacion educacion) {
        educaciones.add(educacion);
    }

    public Educacion obtenerEducacion(int indice) {
        return educaciones.get(indice);
    }

    public void deleteEducacion(Long educacionId) {
        for (Iterator<Educacion> it = educaciones.iterator(); it.hasNext();) {
            Educacion educacion = it.next();
            if (educacion.getId().equals(educacionId)) {
                educacion.setPersona(null);
                it.remove();
            }
        }
    }

    public List<Educacion> getAllEducaciones() {
        return this.educaciones;
    }

    public Long getId() {
        return id;
    }
}
