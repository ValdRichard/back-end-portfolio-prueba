/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.PortfolioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valdiviaricardo
 */
@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    private IEducacionService educacionService;
    
    @Autowired
    private IExperienciaService experienciaService;
    
    @Autowired
    private IHardSkillService hardSKillService;
    
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IProyectoService proyectoService;
    
    @Autowired
    private ISoftSkillService softSkillService;
   
    
    @Override
    public PortfolioDto getPortfolio() {
        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setPersona(personaService.getPersona(1L));
        portfolioDto.setEducaciones(educacionService.getAllEducaciones());
        portfolioDto.setExperiencias(experienciaService.getAllExperiencias());
        portfolioDto.setHardSkills(hardSKillService.getAllHardSkills());
        portfolioDto.setProyectos(proyectoService.getAllProyectos());
        portfolioDto.setSoftSkills(softSkillService.getAllSoftSkills());
        return portfolioDto;
    }
}
