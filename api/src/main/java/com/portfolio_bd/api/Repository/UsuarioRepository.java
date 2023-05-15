/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_bd.api.Repository;

import com.portfolio_bd.api.Model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author valdiviaricardo
 */
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
   
    Optional<Usuario> findOneByEmail(String email);
    
}