package br.com.ydcns.AppFilmes.exceptions;

public class FilmesVerificaSeExiste extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FilmesVerificaSeExiste(String titulo) {
		super("Filme com Titulo: " + titulo + " já está cadastrado.");
	}
}