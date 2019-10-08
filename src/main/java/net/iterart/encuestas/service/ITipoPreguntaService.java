/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.List;
import net.iterart.encuestas.entities.TipoPregunta;

/**
 *
 * @author PC
 */
public interface ITipoPreguntaService {
    
    public List<TipoPregunta> findAll();
	
	public void save(TipoPregunta tipopregunta);
	
	public TipoPregunta findOne(Integer id);
	
	public void delete(Integer id);
}
