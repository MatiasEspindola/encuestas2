package net.iterart.encuestas.service;

import java.util.List;

import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.entities.Localidad;

public interface IEncuestaService {

	public List<Encuesta> findAll();
	
	public void save(Encuesta encuesta);
	
	public Encuesta findOne(Integer id);
	
	public void delete(Integer id);
	
	public List<Localidad> findLocalidades();
}
