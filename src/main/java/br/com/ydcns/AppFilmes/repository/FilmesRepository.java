package br.com.ydcns.AppFilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ydcns.AppFilmes.model.FilmesModel;

@Repository
public interface FilmesRepository extends JpaRepository<FilmesModel, Long> {
	
}
