package com.example.ActivityWSFacisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ActivityWSFacisa.entity.Aluno;
import com.example.ActivityWSFacisa.excepetions.UserAlreadyExistsException;
import com.example.ActivityWSFacisa.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Optional<Aluno> getByRdm(int rdm) {
		return alunoRepository.findById(rdm);
	}

	public List<Aluno> listAllAlunos() {
		return (List<Aluno>) alunoRepository.findAll();
	}

	public Aluno criarAluno(Aluno aluno) throws UserAlreadyExistsException {

		if (aluno == null) {
			return alunoRepository.save(aluno);
		}

		throw new UserAlreadyExistsException();
	}

	public Aluno updateAluno(Aluno alunoNovo) {
		Aluno aluno = alunoRepository.findByRdm(alunoNovo.getRdm());
		aluno.setName(alunoNovo.getName());
		aluno.setName(alunoNovo.getName());
		aluno.setCourse(alunoNovo.getCourse());
		return alunoRepository.save(aluno);
	}

	public void deleteAlunoByRdm(int rdm) {
		alunoRepository.deleteById(rdm);
	}

}
