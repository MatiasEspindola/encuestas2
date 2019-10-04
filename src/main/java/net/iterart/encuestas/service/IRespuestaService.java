/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.List;
import net.iterart.encuestas.entities.Pregunta;

import net.iterart.encuestas.entities.Respuesta;

/**
 *
 * @author PC
 */
public interface IRespuestaService {
    
    public List<Respuesta> findAll();
	
	public void save(Respuesta respuesta);
	
	public Respuesta findOne(Integer id);
	
	public void delete(Integer id);
        
        public List<Respuesta> findByPregunta(Pregunta pregunta);
    
}
