package br.inatel.myrestapi.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.myrestapi.model.Curso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class CursoControllerTest {

	private static final String CURSO_URI = "localhost:8080/curso";
	private static final String CURSO_URI_PATH_ID = "localhost:8080/curso/1";

	@Test
	void whenListar_thenListaOK() {
		List<Curso> listaCurso = new ArrayList<Curso>();
		
		Flux<Curso> flux = WebClient.create()
				.get()
				.uri(CURSO_URI)
				.retrieve()
				.bodyToFlux(Curso.class)
				;

		flux.subscribe(c -> listaCurso.add(c) );
		flux.blockLast();//bloqueia até a resposta chegar

		assertFalse( listaCurso.isEmpty() );
	}

	
	
	@Test
	void testBuscar() {
		Curso cursoEncontrado = null;
		
		Mono<Curso> monoCurso = WebClient.create()
				.get()
				.uri(CURSO_URI_PATH_ID)
				.retrieve()
				.bodyToMono(Curso.class)
				;

		monoCurso.subscribe();
		monoCurso.block();
		

//		assertNotNull( cursoEncontrado );
	}


	@Test
	void testCriar() {
	}

	@Test
	void testAtualizar() {
	}

	@Test
	void testRemover() {
	}

}
