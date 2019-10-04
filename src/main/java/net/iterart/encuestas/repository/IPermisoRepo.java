/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.repository;

import net.iterart.encuestas.entities.Permiso;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PC
 */
public interface IPermisoRepo extends CrudRepository<Permiso, Integer>{
    
}
