/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import net.iterart.encuestas.entities.Permiso;

/**
 *
 * @author PC
 */
public interface IPermisoService {
    
     public Permiso findById(Integer id);
    
}
