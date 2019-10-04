/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.HashSet;
import java.util.List;
import net.iterart.encuestas.entities.Usuario;
import net.iterart.encuestas.repository.IPermisoRepo;
import net.iterart.encuestas.repository.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Service
public class IUsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepo usuarioRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsuario(String username) {
        return usuarioRepo.findByUsuario(username);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

   @Override
    @Transactional
    public void updateSalt(Integer id, String salt) {
        usuarioRepo.updateSalt(id, salt);
    }

}
