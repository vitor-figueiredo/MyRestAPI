package br.inatel.myrestapi.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.inatel.myrestapi.model.Curso;

@Service
public class CursoService {
	
	private Map<Long, Curso> mapa = new HashMap<>();
	
	@PostConstruct
	private void inicializarMapa() {
		Curso c1 = new Curso(1L, "Rest com Spring Boot", 20);
		Curso c2 = new Curso(2L, "Programação Java 11", 80);
		Curso c3 = new Curso(3L, "Dominando o Eclipse", 120);
		
		mapa.put(c1.getId(), c1);
		mapa.put(c2.getId(), c2);
		mapa.put(c3.getId(), c3);
	}

	
	public Curso buscarCursoPeloId(Long cursoId) {
		Curso curso = mapa.get( cursoId );
		return curso;
	}
	
	
	public List<Curso> pesquisarCurso() {
		return mapa.entrySet().stream()
				.map(m -> m.getValue() )
				.collect(Collectors.toList());
	}
	
	
	public Curso criarCurso(Curso curso) {
		Long cursoId = gerarCursoIdUnico();
		curso.setId(cursoId);
		
		mapa.put(cursoId, curso);
		return curso;
	}
	
	
	public void atualizarCurso(Curso curso) {
		mapa.put(curso.getId(), curso);
	}
	
	
	public void removerCurso(Long cursoId) {
		mapa.remove(cursoId);
	}
	
	
	//utilitarios...
	
	private Long gerarCursoIdUnico() {
		return System.currentTimeMillis();
	}

}















