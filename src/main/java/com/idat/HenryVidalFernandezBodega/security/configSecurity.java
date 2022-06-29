package com.idat.HenryVidalFernandezBodega.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class configSecurity extends WebSecurityConfigurerAdapter {

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("henry").password(passwordEncoder().encode("he123456")).roles("ADMIN");
		
		auth.inMemoryAuthentication().withUser("Juan").password(passwordEncoder().encode("ju123456")).roles("USER");
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.antMatchers("/producto/v1/listar").permitAll()
			.antMatchers("/producto/v1/listar").access("hasRole('USER')")
			.antMatchers("/producto/v1/actualizar").access("hasRole('ADMIN')")
			.antMatchers("/producto/v1/guardar").access("hasRole('ADMIN')")
			.antMatchers("/producto/v1/eliminar").access("hasRole('ADMIN')")
			.antMatchers("/producto/v1/listar/**").access("hasRole('ADMIN')")
			.antMatchers("/bodega/v1/**").access("hasRole('ADMIN')")
			.antMatchers("/cliente/v1/**").access("hasRole('ADMIN')")
			.antMatchers("/usuario/v1/**").access("hasRole('ADMIN')");
			
		
		http.authorizeRequests().and().httpBasic();
		http.authorizeRequests().and().csrf().disable();
	}

}
