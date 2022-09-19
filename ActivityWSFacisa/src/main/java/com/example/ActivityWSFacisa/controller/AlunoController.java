package com.example.ActivityWSFacisa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActivityWSFacisa.entity.Aluno;
import com.example.ActivityWSFacisa.service.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@RequestMapping(value = "/aluno")
	public ResponseEntity<List<Aluno>> listAllAlunos() {
		return new ResponseEntity<List<Aluno>>(alunoService.listAllAlunos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{rdm}")
	public Optional<Aluno> getAluno(@PathVariable int rdm) {
		Optional<Aluno> aluno = alunoService.getByRdm(rdm);
		return aluno;
	}

	@RequestMapping(value = "/createAluno")
	public ResponseEntity<String> createAluno(@RequestBody Aluno aluno) {

		try {
			alunoService.criarAluno(aluno);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/updateAluno{rdm}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable Aluno aluno) {
		Aluno alunoNovo = alunoService.updateAluno(aluno);
		return new ResponseEntity<Aluno>(alunoNovo, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteByRdm{rdm}")
	public ResponseEntity<Aluno> deleteAlunoByRdm(@RequestBody int rdm) {
		alunoService.deleteAlunoByRdm(rdm);
		return new ResponseEntity<Aluno>(HttpStatus.NO_CONTENT);

	}

}
