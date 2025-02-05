package br.com.ydcns.AppFilmes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.ydcns.AppFilmes.exceptions.FilmesNaoEncontradosException;
import br.com.ydcns.AppFilmes.exceptions.FilmesVerificaSeExiste;
import br.com.ydcns.AppFilmes.models.FilmesModel;
import br.com.ydcns.AppFilmes.repositories.FilmesRepository;
import jakarta.annotation.PostConstruct;

@Service
public class FilmesService {
	
	@Autowired
	private FilmesRepository filmesRepository;
	
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
	
	public FilmesModel criarFilme(FilmesModel filme) {
		String tituloFormatado = filme.getTitulo().trim();
		filme.setTitulo(tituloFormatado);
		
		boolean existeFilme = filmesRepository.existsByTitulo(tituloFormatado);
		if (existeFilme) {
			throw new FilmesVerificaSeExiste(filme.getTitulo());
		}
		return filmesRepository.save(filme); 
	}
	
	public List<FilmesModel> listarFilmes() {
		return filmesRepository.findAll();
	}

	public Optional<FilmesModel> buscarPorId(Long id) {
		Optional<FilmesModel> filme = filmesRepository.findById(id);
		if (filme.isEmpty()) {
			throw new FilmesNaoEncontradosException(id);
		}
		return filme;	
	}

	public void apagarFilme(Long id) {
		Optional<FilmesModel> filme = filmesRepository.findById(id);
		if (filme.isEmpty()) {
			throw new FilmesNaoEncontradosException(id);
		}
		filmesRepository.deleteById(id);
	}

	public FilmesModel atualizarFilme(Long id, FilmesModel filme) {
		   FilmesModel filmeExistente = filmesRepository.findById(id)
				.orElseThrow(() -> new FilmesNaoEncontradosException(id));
		
			filmeExistente.setTitulo(filme.getTitulo());
			filmeExistente.setGenero(filme.getGenero());
			filmeExistente.setAnoLancamento(filme.getAnoLancamento());
			
			return filmesRepository.save(filmeExistente);
		}
	}

	