/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.SoftSkillDto;

/**
 *
 * @author valdiviaricardo
 */
public interface ISoftSkillService {
    
    public void crearSoftSkill(SoftSkillDto habBlanda);
    
    public boolean editarSoftSkill(Long id, SoftSkillDto habBlanda);
    
    public void borrarSoftSkill(Long id);
    
}