package br.inatel.myrestapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


class MyRestApiApplicationTests {
	
	public static void main(String[] args) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI("http://localhost:8080/curso"))
			.GET()
			.build();
		
		HttpResponse<String> response = HttpClient.newHttpClient()
			.send(request, BodyHandlers.ofString() );
	
		System.out.println( response.body() );
		
	}
	
	


}
