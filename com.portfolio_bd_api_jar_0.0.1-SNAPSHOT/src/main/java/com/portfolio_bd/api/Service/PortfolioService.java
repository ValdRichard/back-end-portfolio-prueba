/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.ExperienciaDto;
import com.portfolio_bd.api.Dto.HardSkillDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Dto.PortfolioDto;
import com.portfolio_bd.api.Dto.ProyectoDto;
import com.portfolio_bd.api.Dto.SoftSkillDto;
import com.portfolio_bd.api.Model.Educacion;
import com.portfolio_bd.api.Model.Experiencia;
import com.portfolio_bd.api.Model.HardSkill;
import com.portfolio_bd.api.Model.Persona;
import com.portfolio_bd.api.Model.Proyecto;
import com.portfolio_bd.api.Model.SoftSkill;
import com.portfolio_bd.api.Repository.EducacionRepository;
import com.portfolio_bd.api.Repository.ExperienciaRepository;
import com.portfolio_bd.api.Repository.HardSkillRepository;
import com.portfolio_bd.api.Repository.PersonaRepository;
import com.portfolio_bd.api.Repository.ProyectoRepository;
import com.portfolio_bd.api.Repository.SoftSkillRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class PortfolioService implements IPortfolioService {
    
    //inyecta las dependencias necesarias
    @Autowired public PersonaRepository repoPersona; 
    @Autowired public EducacionRepository repoEdu;
    @Autowired public ExperienciaRepository repoExpe;
    @Autowired public HardSkillRepository repoTecnica;
    @Autowired public SoftSkillRepository repoBlanda;
    @Autowired public ProyectoRepository repoProye;
    
    
    @Override
    public PortfolioDto getPortfolio() {

        // recupera los datos desde la persistencia
        PersonaDto persoDto = this.getPersonaDto();
        List<EducacionDto> listaEduDto = this.listarEducacionDto();
        List<ExperienciaDto> listaExpeDto = this.listarExperienciaDto();
        List<HardSkillDto> listaHabTecnicaDto = this.listarHardSkillDto();
        List<SoftSkillDto> listaHabBlandaDto = this.listarSoftSkillDto();
        List<ProyectoDto> listaProyeDto = this.listarProyectoDto();
        
        // asigna los datos recuperados al portfolio
        PortfolioDto portfolio = new PortfolioDto();
        //datos de persona
        portfolio.setPersona(persoDto);
        //listas de secciones
        portfolio.setEducaciones(listaEduDto);
        portfolio.setExperiencias(listaExpeDto);
        portfolio.setHabTecnicas(listaHabTecnicaDto);
        portfolio.setHabBlandas(listaHabBlandaDto);
        portfolio.setProyectos(listaProyeDto);

        // entrega portfolio
        return portfolio;
    }
    
    @Override
    public Persona getPersona() {
        long personaId = 1; //"Harcodeo" id de la única persona disponible
        Persona perso = repoPersona.findById(personaId).orElse(null);
        return perso;
    }
    
    @Override
    public PersonaDto getPersonaDto() {
        Persona perso = this.getPersona();
        PersonaDto persoDto = new PersonaDto(perso.getId(),perso.getNombre(), perso.getOcupacion(),perso.getBannerUrl(),perso.getEmail(),perso.getLinkedinUrl(),perso.getGithubUrl(),perso.getDescripcion(),perso.getImgUrl());
        return persoDto;
    }

    @Override
    public boolean editarPersona(PersonaDto perso) {
        if (!repoPersona.existsById(perso.getId())){
            return false;
        } else {
            Persona persoEditada = Persona.getInstance();
            persoEditada.setNombre(perso.getNombre());
            persoEditada.setOcupacion(perso.getOcupacion());
            persoEditada.setBannerUrl(perso.getBannerUrl());
            persoEditada.setEmail(perso.getEmail());
            persoEditada.setLinkedinUrl(perso.getLinkedinUrl());
            persoEditada.setGithubUrl(perso.getGithubUrl());
            persoEditada.setDescripcion(perso.getDescripcion());
            persoEditada.setImgUrl(perso.getImgUrl());
            repoPersona.save(persoEditada);
            return true;
        }
    }
    
    @Override
    public List<EducacionDto> listarEducacionDto() {
        List<Educacion> listaEdu = repoEdu.findAll();
        List<EducacionDto> listaEduDto = new ArrayList<EducacionDto>();
        for (int i = 0; i < listaEdu.size(); i++) {
            Educacion edu = listaEdu.get(i);
            EducacionDto eduDto = new EducacionDto(edu.getId(), edu.getPersona().getId(), edu.getTituloEdu(), edu.getPeriodoEdu(), edu.getInstitucionEdu(), edu.getDescripcionEdu(), edu.getUrlLogoEdu());
            listaEduDto.add(eduDto);
        }
        return listaEduDto;
    }
    
    @Override
    public List<ExperienciaDto> listarExperienciaDto() {
        List<Experiencia> listaExpe = repoExpe.findAll();
        List<ExperienciaDto> listaExperienciaDto = new ArrayList<ExperienciaDto>();
        for (int i = 0; i < listaExpe.size(); i++) {
            Experiencia expe = listaExpe.get(i);
            ExperienciaDto expeDto = new ExperienciaDto(expe.getId(), expe.getPersona().getId(), expe.getPuestoExpe(), expe.getPeriodoExpe(), expe.getOrganismoExpe(), expe.getDescripcionExpe(), expe.getUrlLogoExpe());
            listaExperienciaDto.add(expeDto);
        }
        return listaExperienciaDto;
    }
    
    @Override
    public List<HardSkillDto> listarHardSkillDto() {
        List<HardSkill> listaHabTecnica = repoTecnica.findAll();
        List<HardSkillDto> listaHabTecnicaDto = new ArrayList<HardSkillDto>();
        for (int i = 0; i < listaHabTecnica.size(); i++) {
            HardSkill habTecnica = listaHabTecnica.get(i);
            HardSkillDto habTecnicaDto = new HardSkillDto(habTecnica.getId(), habTecnica.getPersona().getId(), habTecnica.getNivelHabilidad(), habTecnica.getNombreHabilidad(), habTecnica.getUrlIcono());
            listaHabTecnicaDto.add(habTecnicaDto);
        }
        return listaHabTecnicaDto;
    }
    
    @Override
    public List<SoftSkillDto> listarSoftSkillDto() {
        List<SoftSkill> listahabBlanda = repoBlanda.findAll();
        List<SoftSkillDto> listaHabBlandaDto = new ArrayList<SoftSkillDto>();
        for (int i = 0; i < listahabBlanda.size(); i++) {
            SoftSkill habBlanda = listahabBlanda.get(i);
            SoftSkillDto habBlandaDto = new SoftSkillDto(habBlanda.getId(), habBlanda.getPersona().getId(), habBlanda.getNombreHabilidad(), habBlanda.getUrlIcono());
            listaHabBlandaDto.add(habBlandaDto);
        }
        return listaHabBlandaDto;
    }
    
    @Override
    public List<ProyectoDto> listarProyectoDto() {
        List<Proyecto> listaProye = repoProye.findAll();
        List<ProyectoDto> listaProyeDto = new ArrayList<ProyectoDto>();
        for (int i = 0; i < listaProye.size(); i++) {
            Proyecto proye = listaProye.get(i);
            ProyectoDto proyeDto = new ProyectoDto(proye.getId(), proye.getPersona().getId(), proye.getNombreProye(), proye.getDescripcionProye(), proye.getImgUrl(), proye.getRepoUrl(), proye.getLiveUrl());
            listaProyeDto.add(proyeDto);
        }
        return listaProyeDto;
    }
    
}