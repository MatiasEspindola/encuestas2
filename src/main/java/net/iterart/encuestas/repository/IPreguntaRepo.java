/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.repository;

import java.util.List;
import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.entities.Pregunta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PC
 */
public interface IPreguntaRepo extends CrudRepository<Pregunta, Integer>{
    
    @Query("Select p from Pregunta p where p.encuesta =?1")
    public List<Pregunta> findByEncuesta(Encuesta encuesta);
    
}
