/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.HardSkillDto;

/**
 *
 * @author valdiviaricardo
 */
public interface IHardSkillService {
    
    public void crearHardSkill(HardSkillDto habTecnica);
    
    public boolean editarHardSkill(Long id, HardSkillDto habTecnica);
    
    public void borrarHardSkill(Long id);
    
}