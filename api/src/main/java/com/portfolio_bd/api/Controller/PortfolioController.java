/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Controller;

import com.portfolio_bd.api.Dto.PortfolioDto;
import com.portfolio_bd.api.Service.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valdiviaricardo
 */
@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    
    @Autowired
    private IPortfolioService portfolioService;
    
    @GetMapping("/get")
    public PortfolioDto getById() {
        return portfolioService.getPortfolio();
    }
}
