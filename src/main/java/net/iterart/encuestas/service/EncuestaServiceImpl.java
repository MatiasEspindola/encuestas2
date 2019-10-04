package net.iterart.encuestas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.entities.Localidad;
import net.iterart.encuestas.repository.IEncuestaRepo;
import net.iterart.encuestas.repository.ILocalidadRepo;

@Service
public class EncuestaServiceImpl implements IEncuestaService {
	
	@Autowired
	IEncuestaRepo repo;
	
	@Autowired
	ILocalidadRepo locRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Encuesta> findAll() {
		return (List<Encuesta>) repo.findAll();
	}

	@Override
	@Transactional
	public void save(Encuesta encuesta) {
		repo.save(encuesta);
	}

	@Override
	@Transactional(readOnly = true)
	public Encuesta findOne(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Localidad> findLocalidades() {
		return (List<Localidad>) locRepo.findAll();
	}

}
