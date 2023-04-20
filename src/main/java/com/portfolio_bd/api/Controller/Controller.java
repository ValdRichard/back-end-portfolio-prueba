/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

/**
 *
 * @author valdiviaricardo
 */
import com.portfolio_bd.api.Dto.EducacionDto;
import com.portfolio_bd.api.Dto.ExperienciaDto;
import com.portfolio_bd.api.Dto.HardSkillDto;
import com.portfolio_bd.api.Dto.PersonaDto;
import com.portfolio_bd.api.Dto.PortfolioDto;
import com.portfolio_bd.api.Dto.ProyectoDto;
import com.portfolio_bd.api.Dto.RespuestaDto;
import com.portfolio_bd.api.Dto.SoftSkillDto;
import com.portfolio_bd.api.Service.IEducacionService;
import com.portfolio_bd.api.Service.IExperienciaService;
import com.portfolio_bd.api.Service.IHardSkillService;
import com.portfolio_bd.api.Service.IPortfolioService;
import com.portfolio_bd.api.Service.IProyectoService;
import com.portfolio_bd.api.Service.ISoftSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@CrossOrigin (origins = "http://localhost:4200/", maxAge = 3600)
public class Controller {
    
    //inyecta las dependencias necesarias para ejecutar las peticiones que vengan del cliente
    @Autowired private IEducacionService serviEdu;
    @Autowired private IExperienciaService serviExpe;
    @Autowired private IHardSkillService serviHabTecnica;
    @Autowired private ISoftSkillService serviHabBlanda;
    @Autowired private IProyectoService serviProyecto;
    @Autowired private IPortfolioService serviPortfolio;
        
    
    @GetMapping ("/portfolio")
    @ResponseBody
    public ResponseEntity<PortfolioDto> getPortfolio() {
        PortfolioDto portfolio = serviPortfolio.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }

    
    @PutMapping ("/editarPersona")
    public ResponseEntity<RespuestaDto> editarPersona(@RequestBody PersonaDto perso) {
        if (!serviPortfolio.editarPersona(perso)){
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡La información personal ha sido actualizada!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    /*=============================================
    //para pruebas 
    @GetMapping ("/persona")
    @ResponseBody
    public ResponseEntity<Persona> getPersona() {
        Persona perso = serviPortfolio.getPersona();
        return new ResponseEntity<>(perso, HttpStatus.OK);
    }
     //para pruebas 
    @GetMapping ("/listaEdu")
    @ResponseBody
    public List<EduDto> listarEduDto(){
        return serviPortfolio.listarEduDto();
    }
    //============================================*/
    
  
    
    @PostMapping ("/nuevoProyecto")
    public ResponseEntity<RespuestaDto> agregarProyecto(@RequestBody ProyectoDto proyecto){
        serviProyecto.crearProyecto(proyecto);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/borrarProyecto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarProyecto(@PathVariable Long id){
        serviProyecto.borrarProyecto(id);
    }
    
    @PutMapping ("/editarProyecto/{id}")
    public ResponseEntity<RespuestaDto> editarProyecto(@PathVariable Long id, @RequestBody ProyectoDto proyecto){
        if (!serviProyecto.editarProyecto(id, proyecto)){
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    
    
  // HABILIDAD BLANDA ABM
    
    @PostMapping ("/nuevaHabBlanda")
    public ResponseEntity<RespuestaDto> agregarHabBlanda(@RequestBody SoftSkillDto habBlanda){
        serviHabBlanda.crearSoftSkill(habBlanda);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);

    }
    
    @DeleteMapping ("/borrarHabBlanda/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarHabBlanda(@PathVariable Long id){
        serviHabBlanda.borrarSoftSkill(id);
    }
    
    @PutMapping ("/editarHabBlanda/{id}")
    public ResponseEntity<RespuestaDto> editarHabBlanda(@PathVariable Long id, @RequestBody SoftSkillDto habBlanda){
        if (!serviHabBlanda.editarSoftSkill(id, habBlanda)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
   
    
  // HABILIDAD TECNICA ABM
    
    @PostMapping ("/nuevaHabTecnica")
    public ResponseEntity<RespuestaDto> agregarHabTecnica(@RequestBody HardSkillDto habTecnica){
        serviHabTecnica.crearHardSkill(habTecnica);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("borrarHabTecnica/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarHabTecnica(@PathVariable Long id) {
        serviHabTecnica.borrarHardSkill(id);
    }   
    
    @PutMapping ("/editarHabTecnica/{id}")
    public ResponseEntity<RespuestaDto> editarHabTecnica(@PathVariable Long id, @RequestBody HardSkillDto habTecnica) {
        if (!serviHabTecnica.editarHardSkill(id, habTecnica)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
   
    }
  
    
  // EXPERIENCIA ABM
    
    @PostMapping ("/nuevaExpe")
    public ResponseEntity<RespuestaDto> agregarExperiencia(@RequestBody ExperienciaDto expe){
        serviExpe.crearExperiencia(expe);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarExpe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarExperiencia(@PathVariable Long id){
        serviExpe.borrarExperiencia(id);
    }
    
    @PutMapping ("/editarExpe/{id}")
    public ResponseEntity<RespuestaDto> editarExperiencia(@PathVariable Long id, @RequestBody ExperienciaDto expe) {
        if (!serviExpe.editarExperiencia(id, expe)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!.");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    
    
  // EDUCACION ABM
  
    @PostMapping ("/nuevaEdu")
    public ResponseEntity<RespuestaDto> agregarEducacion(@RequestBody EducacionDto edu){
        serviEdu.crearEducacion(edu);
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido agregado!");
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/borrarEdu/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarEducacion(@PathVariable Long id){
        serviEdu.borrarEducacion(id);
    }
    
    @PutMapping ("/editarEdu/{id}")
    public ResponseEntity<RespuestaDto> editarEducacion(@PathVariable Long id, @RequestBody EducacionDto edu) {
        if (!serviEdu.editarEducacion(id, edu)) {
            RespuestaDto resp = new RespuestaDto(false, "Ups! El id proporcionado no existe :(");
            return new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }
        RespuestaDto resp = new RespuestaDto(true, "¡El elemento ha sido actualizado!");
        return new ResponseEntity(resp, HttpStatus.OK);
    }
      
}