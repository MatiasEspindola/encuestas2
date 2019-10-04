/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.repository;

import java.util.List;

import net.iterart.encuestas.entities.Pregunta;
import net.iterart.encuestas.entities.Respuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PC
 */
public interface IRespuestaRepo extends CrudRepository<Respuesta, Integer> {
    
    @Query("Select r from Respuesta r where r.pregunta =?1")
    public List<Respuesta> findByPregunta(Pregunta pregunta);
    
}
