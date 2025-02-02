package br.com.ydcns.AppFilmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ydcns.AppFilmes.model.FilmesModel;
import br.com.ydcns.AppFilmes.service.FilmesService;

@RestController
@RequestMapping("/api")
public class FilmesController {
	
	@Autowired
	private FilmesService filmesService;
	
	@GetMapping
	public List<FilmesModel> listarFilmes() {
		return filmesService.listarFilmes();		
	}
	
	@PostMapping
	public ResponseEntity<FilmesModel> criarFilme(@RequestBody FilmesModel filme) {
		FilmesModel filmeSalvo = filmesService.criarFilme(filme);
		return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo); 
		
	}
}
