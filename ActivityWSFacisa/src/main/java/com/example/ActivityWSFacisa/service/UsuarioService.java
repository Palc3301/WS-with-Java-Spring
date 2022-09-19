package com.example.ActivityWSFacisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ActivityWSFacisa.entity.Usuario;
import com.example.ActivityWSFacisa.excepetions.UserAlreadyExistsException;
import com.example.ActivityWSFacisa.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario getById(int id) {
		return usuarioRepository.findById(id);
	}

	public List<Usuario> listAllUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public Usuario criarUsuario(Usuario usuario) throws UserAlreadyExistsException {

		if (usuario == null) {
			return usuarioRepository.save(usuario);
		}

		throw new UserAlreadyExistsException();
	}

	public Usuario updateUsuario(Usuario usuarioNovo) {

		Usuario usuario = usuarioRepository.findById(usuarioNovo.getId());
		usuario.setName(usuarioNovo.getName());
		usuario.setPassword(usuarioNovo.getPassword());
		usuario.setUsuario(usuarioNovo.getUsuario());
		return usuarioRepository.save(usuario);
	}

	public void deleteUsuarioById(int id) {
		usuarioRepository.deleteById(id);
	}

}
