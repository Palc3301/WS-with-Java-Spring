package com.example.ActivityWSFacisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActivityWSFacisa.entity.Aluno;
import com.example.ActivityWSFacisa.entity.User;
import com.example.ActivityWSFacisa.service.AlunoService;

@RestController
@RequestMapping(value = "aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listAllAlunos() {
		return new ResponseEntity<List<Aluno>>(alunoService.listAllAlunos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{rdm}", method = RequestMethod.GET)
	public Aluno getAluno(@PathVariable int id) {
		Aluno aluno = alunoService.getByRdm(id);
		return aluno;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createAluno(@RequestBody Aluno aluno) {
		
		try {
			alunoService.save(aluno);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
