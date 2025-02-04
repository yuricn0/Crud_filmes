package br.com.ydcns.AppFilmes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ydcns.AppFilmes.models.FilmesModel;
import br.com.ydcns.AppFilmes.repositories.FilmesRepository;
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
	
	public void apagarFilme(Long id) {
		Optional<FilmesModel> filme = filmesRepository.findById(id);
		if (filme.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado");
		}
		filmesRepository.deleteById(id);
	
	}
	
	
	 @PostConstruct
	 public void inserirFilmesNoBanco() {
	            List<FilmesModel> filmes = List.of(
	                new FilmesModel("O Poderoso Chefão", "Crime", 1972),
	                new FilmesModel("Interestelar", "Ficção Científica", 2014),
	                new FilmesModel("Clube da Luta", "Drama", 1999),
	                new FilmesModel("Matrix", "Ficção Científica", 1999)
	            );

	            filmesRepository.saveAll(filmes);
	        }
	    }
