/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.validation.Valid;
import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.entities.Pregunta;
import net.iterart.encuestas.entities.Respuesta;
import net.iterart.encuestas.service.IEncuestaService;
import net.iterart.encuestas.service.IPreguntaService;
import net.iterart.encuestas.service.IRespuestaService;
import net.iterart.encuestas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author PC
 */
@Controller
@SessionAttributes("respuesta")
public class RespuestaController {

    @Autowired
    IEncuestaService encServ;

    @Autowired
    IPreguntaService pregServ;

    @Autowired
    IUsuarioService usuServ;

    @Autowired
    IRespuestaService respServ;
    
    boolean activarAnterior = false;
    boolean activarSiguiente = false;
    boolean respondido = false;

    @GetMapping("/verEncuesta/{idEncuesta}/{idPregunta}") // EL 0 ... SE GUARDA EN ID2
    public String crear(@PathVariable(value = "idEncuesta") int id1, @PathVariable(value = "idPregunta") int id2, Map<String, Object> model,
            RedirectAttributes flash, Locale locale, Model m) {

        Encuesta encuesta = encServ.findOne(id1);
        
        model.put("encuesta", encuesta);

        List<Pregunta> preguntas = pregServ.findByEncuesta(encuesta);

        model.put("titulo", encuesta.getTitulo());
        

        Pregunta pregunta = preguntas.get(id2);
        

        // ACTIVAR - DESACTIVAR (Siguiente - Anterior)
        if(id2 == 0){
            activarAnterior = false;
        }else{
            activarAnterior = true;
        }
        
        if(id2 < preguntas.size() - 1){
            activarSiguiente = true;
        }else{
            activarSiguiente = false;
        }
            
        model.put("pregunta", pregunta);
        
        // ACTIVAR - DESACTIVAR (Responder - Modificar)
        
        
        model.put("activarAnterior", activarAnterior);
        model.put("activarSiguiente", activarSiguiente);
        model.put("idPregunta", id2);
        
        // VERIFICAR QUE EXISTAN RESPUESTAS EN LAS PREGUNTAS
        if(respServ.findByPregunta(pregunta).isEmpty()){
            model.put("respuesta", "No se ha respondido esta pregunta");
            respondido = false;
        }else{
            model.put("respuesta", respServ.findByPregunta(pregunta).get(0).getRespuesta());
            respondido = true;
        }
        
        
        model.put("respondido", respondido);
        

        return "verEncuesta";
    }


    // RESPUESTA
    @RequestMapping(value = "/verEncuesta", method = RequestMethod.POST)
    public String guardar(@Valid Respuesta respuesta, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash,
            @RequestParam(defaultValue = "opcion") int id) {

        // FORMULARIO DE RESPUESTA
        respServ.save(respuesta);
        status.setComplete();

        flash.addFlashAttribute("success", "Su formulario ha sido enviado con éxito!");

        return "redirect:/encuesta/list";
    }

}
