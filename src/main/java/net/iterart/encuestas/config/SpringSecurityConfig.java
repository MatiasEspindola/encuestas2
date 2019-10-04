/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.config;

import javax.sql.DataSource;
import net.iterart.encuestas.auth.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author PC
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
	LoginSuccessHandler lsh;
	
	@Autowired
	DataSource ds;
        
        @Autowired
	public void ConfigurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		
//		build.userDetailsService(userDetailsService)
//		.passwordEncoder(passEncoder);
		
		
		//Autorizacion con JDBC
		
		build.jdbcAuthentication()
		.dataSource(ds)
		//.passwordEncoder(passEncoder)
		.usersByUsernameQuery("select usuario, salt, activo from usuarios where usuario =?")
		.authoritiesByUsernameQuery("select u.usuario, a.permiso from permisos a inner join usuarios u on u.fk_id_permiso=a.pk_id_permiso where u.usuario=?");
		
		///Autorizacion en memoria
		
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
//		
//		build.inMemoryAuthentication()
//		.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
//		.withUser(users.username("user").password("user").roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/js/**", "/img/**","/registro","/list").permitAll()
//		.antMatchers("/proyectos/listar/**").hasAnyRole("Usuario")
//		.antMatchers("/uploads/**").hasAnyRole("Usuario")
//		.antMatchers("/actividades/**").hasAnyRole("Usuario")
//		.antMatchers("/proyectos/**").hasAnyRole("Usuario")
//		.antMatchers("/tareas/**").hasAnyRole("Usuario")
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.successHandler(lsh)
			.loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}
    
}
