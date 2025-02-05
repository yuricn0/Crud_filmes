package br.com.ydcns.AppFilmes.exceptions;

public class FilmesNaoEncontradosException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FilmesNaoEncontradosException(Long id) {
		super("Filme com ID " + id + " não foi encontrado.");
	}
}