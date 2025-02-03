package br.com.ydcns.AppFilmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppFilmes.model.FilmesModel;
import br.com.ydcns.AppFilmes.repository.FilmesRepository;
import jakarta.annotation.PostConstruct;

@Service
public class FilmesService {
	
	@Autowired
	private FilmesRepository filmesRepository;
	
	public List<FilmesModel> listarFilmes() {
		return filmesRepository.findAll();
	}

	 public FilmesModel criarFilme(FilmesModel filme) {
	        return filmesRepository.save(filme); 
	}
	 
	 @PostConstruct
	 public void inserirFilmesNoBanco() {
	        if (filmesRepository.count() == 0) {
	            List<FilmesModel> filmes = List.of(
	                new FilmesModel("O Poderoso Chefão", "Crime", 1972),
	                new FilmesModel("Interestelar", "Ficção Científica", 2014),
	                new FilmesModel("Clube da Luta", "Drama", 1999),
	                new FilmesModel("Matrix", "Ficção Científica", 1999)
	            );

	            filmesRepository.saveAll(filmes);
	        }
	    }
}
