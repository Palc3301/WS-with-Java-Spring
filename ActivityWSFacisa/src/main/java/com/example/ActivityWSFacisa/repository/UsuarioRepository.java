package com.example.ActivityWSFacisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ActivityWSFacisa.entity.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuario")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findById(int id);

	public Usuario findByName(String name);
}
