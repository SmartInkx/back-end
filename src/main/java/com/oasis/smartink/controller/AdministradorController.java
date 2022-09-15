package com.oasis.smartink.controller;

import com.oasis.smartink.model.Administrador;
import com.oasis.smartink.model.AdministradorLogin;
import com.oasis.smartink.repository.AdministradorRepository;
import com.oasis.smartink.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdministradorController {


	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@GetMapping("/all")
	public ResponseEntity <List<Administrador>> getAll(){
		
		return ResponseEntity.ok(administradorRepository.findAll());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Administrador> getById(@PathVariable Long id) {
		return administradorRepository.findById(id)
									  .map(resposta -> ResponseEntity.ok(resposta))
									  .orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/logar")
	public ResponseEntity<AdministradorLogin> login(@Valid @RequestBody Optional<AdministradorLogin> usuarioLogin) {
		return administradorService.autenticarAdministrador(usuarioLogin)
								   .map(resposta -> ResponseEntity.ok(resposta))
								   .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	
	@PostMapping("/cadastrar")
	public ResponseEntity<Administrador> postAdministrador(@Valid @RequestBody Administrador administrador) {

		return administradorService.cadastrarAdministrador(administrador)
								   .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
								   .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

	}

	
	@PutMapping("/atualizar")
	public ResponseEntity<Administrador> putAdministrador(@Valid @RequestBody Administrador administrador) {
		return administradorService.atualizarAdministrador(administrador)
								   .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
								   .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

}