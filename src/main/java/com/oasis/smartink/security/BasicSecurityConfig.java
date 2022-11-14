package com.oasis.smartink.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	

	@Autowired
	private UserDetailsService userDetailsService;

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		 auth.userDetailsService(userDetailsService);

		 auth.inMemoryAuthentication()
			.withUser("root")
			.password(passwordEncoder().encode("root"))
			.authorities("ROLE_USER");

	}

	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		
		

		http.authorizeRequests()
			.antMatchers("/usuarios/logar").permitAll()
			.antMatchers("/usuarios/all").permitAll()
			.antMatchers("/usuarios/cadastrar").permitAll()
			.antMatchers("/agendamentopiercing/enviaragendamentopiercing").permitAll()
			.antMatchers("/agendamentopiercing").permitAll()
			.antMatchers("/agendamentotatuagem/enviaragendamentotatuagem").permitAll()
			.antMatchers("/agendamentotatuagem").permitAll()
			.antMatchers("/materialpiercing").permitAll()
			.antMatchers("/tipotatuagem").permitAll()
			.antMatchers("/materialpiercing/enviarmaterialpiercing").permitAll()
			.antMatchers("/tipotatuagem/enviartipotatuagem").permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.anyRequest().permitAll()
			.and().httpBasic()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors()
			.and().csrf().disable();
			
	}
}