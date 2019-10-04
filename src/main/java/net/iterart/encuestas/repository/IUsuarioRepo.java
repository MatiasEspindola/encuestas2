/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.repository;

import net.iterart.encuestas.entities.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PC
 */
public interface IUsuarioRepo extends CrudRepository<Usuario, Long> {
    
    @Query("select u from Usuario u where u.usuario =?1")
    public Usuario findByUsuario(String username);
    
    @Modifying
    @Query("update Usuario u set u.salt=?2 where u.id =?1")
    public void updateSalt(Integer id, String salt);
    
}
