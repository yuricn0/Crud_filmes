package br.com.ydcns.AppFilmes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class FilmesExceptionGlobal {

    @ExceptionHandler(FilmesNaoEncontradosException.class)
    public ResponseEntity<Map<String, String>> tratarFilmeNaoEncontrado(FilmesNaoEncontradosException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", ex.getMessage());
	        
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}	
    
    @ExceptionHandler(FilmesVerificaSeExiste.class)
    public ResponseEntity<Map<String, String>> tratarFilmeJaExiste(FilmesVerificaSeExiste ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}