/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;
import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Repository.EducacionRepository;
import com.portfolio_bd.api.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author valdiviaricardo
 */
@Service
public class EducacionService implements IEducacionService {

    /* Inyecto el repositorio 
    La interfaz en la capa repository será quien haga la conexion 
    con JPA y será la intermediaria entre la base de datos y todos los metodos de JPA*/
    @Autowired public EducacionRepository repoEdu;
    @Autowired public PersonaRepository repoPerso;

    //Create - Alta
    @Override
    public void crearEducacion(EducacionDto edu) {
        Persona perso = repoPerso.findById(edu.getPersonaId()).orElse(null);
        Educacion nuevaEdu = new Educacion(perso, edu.getTituloEdu(), edu.getPeriodoEdu(), edu.getInstitucionEdu(), edu.getDescripcionEdu(), edu.getUrlLogoEdu());
        repoEdu.save(nuevaEdu);
    }

    //Update - Actualizar
    @Override
    public boolean editarEducacion(Long id, EducacionDto edu) {
        if (!repoEdu.existsById(id)) {
            return false;
        } else {
            Educacion eduEditada = repoEdu.findById(id).orElse(null);
            eduEditada.setPersona(repoPerso.findById(edu.getPersonaId()).orElse(null));
            eduEditada.setTituloEdu(edu.getTituloEdu());
            eduEditada.setPeriodoEdu(edu.getPeriodoEdu());
            eduEditada.setInstitucionEdu(edu.getInstitucionEdu());
            eduEditada.setDescripcionEdu(edu.getDescripcionEdu());
            eduEditada.setUrlLogoEdu(edu.getUrlLogoEdu());
            repoEdu.save(eduEditada);
            return true;
        }
    }

    //Delete - Baja
    @Override
    public void borrarEducacion(Long id) {
        repoEdu.deleteById(id);
    }
   
}
