package net.iterart.encuestas.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.iterart.encuestas.entities.Encuesta;
import net.iterart.encuestas.service.IEncuestaService;
import net.iterart.encuestas.service.IPreguntaService;
import net.iterart.encuestas.service.IRespuestaService;
import net.iterart.encuestas.service.IUsuarioService;
import org.springframework.security.access.annotation.Secured;

@Controller
@RequestMapping({"/", "/encuesta"})
// ENCUESTA SESSIONATTRIBUTES 
@SessionAttributes("encuesta")
public class EncuestaController {

    @Autowired
    IEncuestaService eS;

    @Autowired
    IPreguntaService preg;


    @Autowired
    IUsuarioService usuServ;
    
        @Autowired
    IRespuestaService respuestaServ;

    @RequestMapping(value = {"/ver"}, method = RequestMethod.GET)
    public String view(Model m) {

        m.addAttribute("title", "Sistema de Encuestas");

        return "encuesta/ver";
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String list(Model m) {

        List<Encuesta> encuestas = eS.findAll();

        m.addAttribute("title", "Listado de Encuestas");
        m.addAttribute("encuestas", encuestas);

        return "encuesta/list";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = {"/form"}, method = RequestMethod.GET)
    public String crear(Model m) {

        Encuesta encuesta = new Encuesta();
        encuesta.setFechaInicio(java.sql.Date.valueOf(LocalDate.now()));
        encuesta.setFechaCaducidad(java.sql.Date.valueOf(LocalDate.now()));

        m.addAttribute("title", "Crear Encuesta");
        m.addAttribute("encuesta", encuesta);
        m.addAttribute("localidades", eS.findLocalidades());

        return "encuesta/form";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/form")
    public String guardar(@Valid Encuesta encuesta, BindingResult r, RedirectAttributes flash, Model model, SessionStatus st) {

        if (r.hasErrors()) {
            model.addAttribute("titulo", "Verifique los errores: ");
            return "encuesta/form";
        }

        String msgFlash = (encuesta.getId() != 0L) ? "Encuesta modificada con éxito..."
                : "Encuesta añadida con éxito...";

        encuesta.setPortadaImg("hola");

        eS.save(encuesta);
        st.setComplete();
        flash.addFlashAttribute("success", msgFlash);

        return "redirect:list";
    }

    
}

   /*
                                        <div class="form-check" th:each="o : ${p.getOpciones()}">
                                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" th:text="${o.opcion}">
                                          
                                        </div> */