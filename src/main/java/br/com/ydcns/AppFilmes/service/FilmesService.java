package br.com.ydcns.AppFilmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppFilmes.model.FilmesModel;
import br.com.ydcns.AppFilmes.repository.FilmesRepository;

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
}
