package com.example.ActivityWSFacisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActivityWSFacisa.entity.Usuario;
import com.example.ActivityWSFacisa.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/usuario")
	public ResponseEntity<List<Usuario>> listAllUsers() {
		return new ResponseEntity<List<Usuario>>(usuarioService.listAllUsuarios(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public Usuario getUser(@PathVariable int id) {
		Usuario usuario = usuarioService.getById(id);
		return usuario;
	}

	@RequestMapping(value = "/createUsuario")
	public ResponseEntity<String> createUser(@RequestBody Usuario usuario) {

		try {
			usuarioService.criarUsuario(usuario);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/updateUsuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Usuario usuario) {
		Usuario usuarioNovo = usuarioService.updateUsuario(usuario);
		return new ResponseEntity<Usuario>(usuarioNovo, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteByID")
	public ResponseEntity<Usuario> deleteAlunoByRdm(@RequestBody int id) {
		usuarioService.deleteUsuarioById(id);
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);

	}
}
