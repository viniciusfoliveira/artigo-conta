package br.com.api.artigos.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.com.api.artigos.model.Conta;
import br.com.api.artigos.service.ContaService;

@RestController
public class ContaResource {

	@Autowired
	private ContaService contaService;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", value = "/conta")
	public ResponseEntity<Void> save(@RequestBody @Valid  Conta conta){
		
		   Conta obj = contaService.save(conta);

		
		/* Retorna a uri do objeto inserido
		    * .path() pega url da requisição
		    * buildAndExpend configura a url passando o id do objeto inserido e conveter para uri
		    * boa pratica retornar a uri
		    * 
		    */
		   
		   java.net.URI uri = ServletUriComponentsBuilder.
				   fromCurrentRequest().path("/{id}") 
				   .buildAndExpand(obj.getId()).toUri();
		   
		   return 	ResponseEntity.created(uri).build();
		
	}
}
