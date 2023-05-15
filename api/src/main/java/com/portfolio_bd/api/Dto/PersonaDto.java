/*
 * Click nbfs: nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs: nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio_bd.api.Dto;

/**
 *
 * @author valdiviaricardo
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {
    private Long id;
    private String imageBanner;
    private String imageFotoPerfil;
    private String imageGithub;
    private String imageLinkedin;
    private String urlGithub;
    private String urlLinkedin;
    private String mail;
    private String nombreyApellido;
    private String descripcion;
}