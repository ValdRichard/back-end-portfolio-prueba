/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Service;

import com.portfolio_bd.api.Dto.PersonaDto;

/**
 *
 * @author valdiviaricardo
 */
public interface IPersonaService {
    
    public boolean editarPersona(Long id, PersonaDto perso);   
}