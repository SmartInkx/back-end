package com.oasis.smartink.model;


public class UsuarioLogin {
	

	private Long id;

	private String nome;

	private String usuario;

	private String senha;

	private String numero;

	private String token;
	
	public UsuarioLogin(Long id, String nome, String numero, String usuario, String senha) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public UsuarioLogin() {} 

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}	
	

	
}