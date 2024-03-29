package com.oasis.smartink.security;

import java.util.Optional;

import com.oasis.smartink.model.Administrador;
import com.oasis.smartink.repository.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdministradorRepository userRepository;



	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

	
		
		Optional<Administrador> usuario = userRepository.findByUsuario(userName);
		
		 
	  
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));


		return usuario.map(UserDetailsImpl::new).get();
	}
}