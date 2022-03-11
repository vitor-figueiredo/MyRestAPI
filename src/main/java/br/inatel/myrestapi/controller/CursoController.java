package br.inatel.myrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.inatel.myrestapi.model.Curso;
import br.inatel.myrestapi.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService servico;

	
	@GetMapping("/{id}")
	public Curso buscar(@PathVariable("id") Long cursoId) {
		Curso curso = servico.buscarCursoPeloId(cursoId);
		if (curso != null) {
			return curso;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping
	public List<Curso> listar() {
		List<Curso> listaCurso = servico.pesquisarCurso();
		return listaCurso;
	}
	
	
	@PostMapping
	public Curso criar(Curso curso) {
		curso = servico.criarCurso(curso);
		return curso;
	}
	
	
	@PutMapping
	public void atualizar(Curso curso) {
		servico.atualizarCurso(curso);
	}
	
	
	@DeleteMapping("{id}")
	public void remover(@PathVariable("id") Long cursoIdRemover) {
		servico.removerCurso(cursoIdRemover);
	}

}
























