/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.List;
import net.iterart.encuestas.entities.Pregunta;
import net.iterart.encuestas.entities.Respuesta;
import net.iterart.encuestas.repository.IRespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Service
public class IRespuestaServiceImpl implements IRespuestaService {

    @Autowired
    IRespuestaRepo repo;

    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> findAll() {
        return (List<Respuesta>) repo.findAll();
    }

    @Override
    @Transactional
    public void save(Respuesta respuesta) {
        repo.save(respuesta);
    }

    @Override
    @Transactional(readOnly = true)
    public Respuesta findOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> findByPregunta(Pregunta pregunta){
        return repo.findByPregunta(pregunta);
    }

}
