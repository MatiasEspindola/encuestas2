/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.List;
import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.entities.Pregunta;
import net.iterart.encuestas.repository.IPreguntaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Service
public class IPreguntaServiceImpl implements IPreguntaService {

    @Autowired
    IPreguntaRepo repo;

    @Override
    @Transactional(readOnly = true)
    public List<Pregunta> findAll() {
        return (List<Pregunta>) repo.findAll();
    }

    @Override
    @Transactional
    public void save(Pregunta pregunta) {
        repo.save(pregunta);
    }

    @Override
    @Transactional(readOnly = true)
    public Pregunta findOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pregunta> findByEncuesta(Encuesta encuesta) {
        return repo.findByEncuesta(encuesta);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
