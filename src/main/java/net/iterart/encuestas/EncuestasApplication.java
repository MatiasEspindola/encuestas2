package net.iterart.encuestas;

import java.util.List;
import net.iterart.encuestas.entities.Usuario;
import net.iterart.encuestas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EncuestasApplication implements CommandLineRunner {
    
    @Autowired
    BCryptPasswordEncoder passEncoder;
    
    @Autowired
    IUsuarioService usuServ;

    @Bean
    BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

	public static void main(String[] args) {
		SpringApplication.run(EncuestasApplication.class, args);
	}
        
        @Override
    public void run(String... args) throws Exception {
//			ufs.deleteAll();
//			ufs.init();

        //Encript de claves:
//       List<Usuario> datos = usuServ.findAll();
//     
//        for(Usuario u : datos){
//          String pass = u.getClave();
//         String encPass = passEncoder.encode(pass);
//           u.setSalt(encPass);          usuServ.updateSalt(u.getId(), encPass);
//          System.out.println("Clave cambiada de: " + u.getClave() + " a " + u.getSalt());
//       }
//
//        String pass = "cgatti2017";
//
//        for (int i = 0; i < 2; i++) {
//            String encriptPass = passEncoder.encode(pass);
//            System.out.println("Password encriptada: ".concat(encriptPass));
//        }
    }

}
