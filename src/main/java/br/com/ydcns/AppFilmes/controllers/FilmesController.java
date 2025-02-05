package br.com.ydcns.AppFilmes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ydcns.AppFilmes.models.FilmesModel;
import br.com.ydcns.AppFilmes.services.FilmesService;

@RestController
@RequestMapping("/api")
public class FilmesController {
	
	@Autowired
	private FilmesService filmesService;
	
	@PostMapping
	public ResponseEntity<FilmesModel> criarFilme(@RequestBody FilmesModel filme) {
		FilmesModel filmeSalvo = filmesService.criarFilme(filme);
		return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo); 
	}
	
	@GetMapping("filmes")
	public List<FilmesModel> listarFilmes() {
		return filmesService.listarFilmes();		
	}
	
	@GetMapping("filmes/{id}")
	public ResponseEntity<FilmesModel> buscarPorId(@PathVariable Long id) {
		  FilmesModel filme = filmesService.buscarPorId(id).get();
		  return ResponseEntity.ok(filme);
	}
	
	@PutMapping("filmes/{id}")
	public ResponseEntity<String> atualizarFilme(@PathVariable Long id, @RequestBody FilmesModel filme) {
		filmesService.atualizarFilme(id, filme);
		return ResponseEntity.ok("Filme atualizado com sucesso");
		
	}
	
	@DeleteMapping("filmes/{id}")
	public ResponseEntity<Void> apagarFilme(@PathVariable Long id) {
		filmesService.apagarFilme(id);
		return ResponseEntity.noContent().build();
	}
}
