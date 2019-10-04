/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.List;
import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.entities.Pregunta;

/**
 *
 * @author PC
 */
public interface IPreguntaService {
    
    public List<Pregunta> findAll();
	
	public void save(Pregunta pregunta);
	
	public Pregunta findOne(Integer id);
	
	public void delete(Integer id);
        
        public List<Pregunta> findByEncuesta(Encuesta encuesta);
	
	
}
