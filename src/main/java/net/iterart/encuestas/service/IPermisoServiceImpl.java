/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import net.iterart.encuestas.entities.Permiso;
import net.iterart.encuestas.repository.IPermisoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Service
public class IPermisoServiceImpl implements IPermisoService{
    
    @Autowired
    IPermisoRepo permisoRepo;

     @Override
    @Transactional(readOnly = true)
    public Permiso findById(Integer id) {
        return permisoRepo.findById(id).orElse(null);
    }
    
}
