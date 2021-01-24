package br.com.api.artigos.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice // centraliza o tratamento de exceção
public class StandardException {

	/*
	 * Verifica a integridade dos dados
	 * */
	
	@ExceptionHandler(DataIntegrityViolationException.class)// para dizer que este metodo é um tratador de exceção
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityViolationException  e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(), "Integridade de dados","Não é permitido valores repetidos nos campos de CPF e EMAIL", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	  /*
     * Verificando se foi passado valores nulos no corpo da requisição
     * */		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> NotNull(MethodArgumentNotValidException e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), 
				"Body", "Não permitido valores nulos", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	  /*
     * Verificando se foi passado valores no corpo da requisição
     * */		
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<StandardError> NotNullException(HttpMediaTypeNotSupportedException e, HttpServletRequest request) {
		StandardError err = new StandardError(System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(), "Body", "Precisa-se passar um json corpo da requisição", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	
  
}
