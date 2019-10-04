/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import net.iterart.encuestas.entities.Usuario;
import net.iterart.encuestas.service.IPermisoService;
import net.iterart.encuestas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author PC
 */
@Controller
@SessionAttributes("usuario")
public class AdministradoresController {

    

    @Autowired
    IUsuarioService usuServ;

  

    @Autowired
    private IPermisoService perServ;

    @Autowired
    BCryptPasswordEncoder passEncoder;

    //@Secured({"ROLE_ADMIN"})
   @GetMapping("/registro")
    public String crearAdministrador(Model m) throws SQLException {

        Usuario usuario = new Usuario();

        m.addAttribute("usuario", usuario);

        return "form";
    }
    

    //@Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "registro", method = RequestMethod.POST)
   public String guardar(Model m, @Valid Usuario usuario,
           
           RedirectAttributes flash) {

       List<Usuario> usuarios = usuServ.findAll();

        for (int i = 0; i < usuarios.size(); i++) {
          if (usuario.getUsuario().equals(usuarios.get(i).getUsuario())) {

                String error = "¡El usuario ya existe!";

               flash.addFlashAttribute("error", error);

            return "redirect:/form";

           }
       }
        
   
//
//       2 = ROLE_UNIDAD
       usuario.setPermiso(perServ.findById(2));
       usuario.setActivo(Boolean.TRUE);

      // GUARDAR EL USUARIO
       usuServ.save(usuario);
//
//        // ENCRIPTAR CLAVE
        String pass = usuario.getClave();
        String encPass = passEncoder.encode(pass);
        usuario.setSalt(pass);
        usuServ.updateSalt(usuario.getId(), encPass); 
//
      return "redirect:/login";
//
   }
}
    
     



