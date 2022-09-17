package com.example.ActivityWSFacisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ActivityWSFacisa.entity.Aluno;
import com.example.ActivityWSFacisa.entity.User;
import com.example.ActivityWSFacisa.excepetions.AlunoAlreadyExistsException;
import com.example.ActivityWSFacisa.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public Aluno getByRdm(int id) {
		return repository.getById(null);
	}

	public List<Aluno> listAllAlunos() {
		return (List<Aluno>) repository.findAll();
	}

	public Aluno save(Aluno aluno) throws AlunoAlreadyExistsException {

		User exist = repository.findByName(aluno.getName());

		if (exist != null) {
			throw new AlunoAlreadyExistsException();
		}
		return repository.save(aluno);
	}

}
