/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.controller;

import java.util.Map;
import javax.validation.Valid;
import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.entities.Pregunta;
import net.iterart.encuestas.service.IEncuestaService;
import net.iterart.encuestas.service.IPreguntaService;
import net.iterart.encuestas.service.ITipoPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author PC
 */
@Controller
@SessionAttributes("pregunta")
@RequestMapping("/pregunta")
public class PreguntaController {
    
    
    @Autowired
    IEncuestaService encServ;
    
     @Autowired
    ITipoPreguntaService tipoServ;
     
      @Autowired
    IPreguntaService preg;
    
    @GetMapping("/crearPregunta/{id}")
    public String crear(@PathVariable(value = "id") Integer id, Map<String, Object> model, RedirectAttributes flash) {
        
        Encuesta encuesta = encServ.findOne(id);
        
       Pregunta pregunta = new Pregunta();
       pregunta.setEncuesta(encuesta);
        
        model.put("pregunta", pregunta);
        model.put("tipodepregunta", tipoServ.findAll());
        
        return "crearPregunta";
    }
    
     @RequestMapping(value = "/crearPregunta", method = RequestMethod.POST)
    public String guardar(@Valid Pregunta pregunta, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {

       
        
        preg.save(pregunta);
        status.setComplete();

        flash.addFlashAttribute("success", "Su formulario ha sido enviado con éxito!");
        
        return "redirect:/list";
    }
    
}
