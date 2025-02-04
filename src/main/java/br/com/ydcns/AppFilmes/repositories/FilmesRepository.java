package br.com.ydcns.AppFilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ydcns.AppFilmes.models.FilmesModel;

@Repository
public interface FilmesRepository extends JpaRepository<FilmesModel, Long> {
	
}
