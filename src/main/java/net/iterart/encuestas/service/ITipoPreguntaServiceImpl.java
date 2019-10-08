/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.service;

import java.util.List;
import net.iterart.encuestas.entities.TipoPregunta;
import net.iterart.encuestas.repository.ITipoPreguntaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Service
public class ITipoPreguntaServiceImpl implements ITipoPreguntaService {
    
     @Autowired
    ITipoPreguntaRepo repoTipo;

     @Override
    @Transactional(readOnly = true)
    public List<TipoPregunta> findAll() {
         return (List<TipoPregunta>) repoTipo.findAll();
    }

    @Override
    @Transactional
    public void save(TipoPregunta tipopregunta) {
       repoTipo.save(tipopregunta);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoPregunta findOne(Integer id) {
        return repoTipo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
       repoTipo.deleteById(id);
    }
    
}
