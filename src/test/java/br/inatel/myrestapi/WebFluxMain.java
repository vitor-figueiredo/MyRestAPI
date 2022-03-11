package br.inatel.myrestapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.myrestapi.model.Curso;
import reactor.core.publisher.Flux;

public class WebFluxMain {
	
	public static void main(String[] args) {
		
		List<Curso> listaCurso = new ArrayList<Curso>();
		
		Flux<Curso> flux = WebClient.create()
				.get()
				.uri("localhost:8080/curso")
				.retrieve()
				.bodyToFlux(Curso.class)
				;

		flux.subscribe(c -> listaCurso.add(c) );
		flux.blockLast();//bloqueia até a resposta chegar

		
		System.out.println("Lista de Cursos:");
		System.out.println( listaCurso );
	}

		
//		for (Curso c : listaCurso) {
//			System.out.println( c.getDescricao() );
//		}
		

}
