package br.com.api.artigos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.artigos.model.Conta;
import br.com.api.artigos.repository.ContaRepository;

@Service
public class ContaService {

	 @Autowired
	 private ContaRepository contaRepository;
	 
	 public Conta save(Conta conta) {
		 
		 return contaRepository.save(conta);
	 }
	 
	 
}
