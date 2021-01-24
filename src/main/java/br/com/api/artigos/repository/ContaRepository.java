package br.com.api.artigos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.artigos.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
