package com.oasis.smartink.service;

import java.nio.charset.Charset;
import java.util.Optional;

import com.oasis.smartink.model.Administrador;
import com.oasis.smartink.model.AdministradorLogin;
import com.oasis.smartink.repository.AdministradorRepository;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;


    public Optional<Administrador> cadastrarAdministrador(Administrador administrador) {

        if (administradorRepository.findByUsuario(administrador.getUsuario()).isPresent())
            return Optional.empty();


        administrador.setSenha(criptografarSenha(administrador.getSenha()));


        return Optional.of(administradorRepository.save(administrador));

    }


    public Optional<Administrador> logarUsuario(Administrador administrador) {

        if (administradorRepository.findByUsuario(administrador.getUsuario()).isPresent())
            return Optional.empty();


        return Optional.of(administradorRepository.save(administrador));

    }


    public Optional<Administrador> atualizarAdministrador(Administrador administrador) {

        if(administradorRepository.findById(administrador.getId()).isPresent()) {


            administrador.setSenha(criptografarSenha(administrador.getSenha()));


            return Optional.ofNullable(administradorRepository.save(administrador));

        }


        return Optional.empty();

    }


    public Optional<AdministradorLogin> autenticarAdministrador(Optional<AdministradorLogin> usuarioLogin) {


        Optional<Administrador> usuario = administradorRepository.findByUsuario(usuarioLogin.get().getUsuario());

        if (usuario.isPresent()) {


            if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {


                usuarioLogin.get().setId(usuario.get().getId());
                usuarioLogin.get().setNome(usuario.get().getNome());
                usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
                usuarioLogin.get().setSenha(usuario.get().getSenha());


                return usuarioLogin;

            }
        }

        return Optional.empty();

    }

    private String criptografarSenha(String senha) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(senha);

    }

    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(senhaDigitada, senhaBanco);

    }


    private String gerarBasicToken(String usuario, String senha) {

        String token = usuario + ":" + senha;
        byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(tokenBase64);

    }

}