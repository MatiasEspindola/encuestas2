package net.iterart.encuestas.repository;

import org.springframework.data.repository.CrudRepository;

import net.iterart.encuestas.entities.Encuesta;

public interface IEncuestaRepo extends CrudRepository<Encuesta, Integer> {
	
	

}
