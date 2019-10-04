/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.List;
import net.iterart.encuestas.entities.Usuario;

/**
 *
 * @author PC
 */
public interface IUsuarioService {

    public List<Usuario> findAll();

    public Usuario findByUsuario(String usuario);

    public void save(Usuario usuario);
    
     public void updateSalt(Integer id, String salt);

}
