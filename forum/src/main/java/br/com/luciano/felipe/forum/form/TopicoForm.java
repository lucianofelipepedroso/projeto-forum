package br.com.luciano.felipe.forum.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.luciano.felipe.forum.modelo.Topico;
import br.com.luciano.felipe.forum.repository.CursoRepository;

public class TopicoForm {

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@NotEmpty
	private String mensagem;


	@NotNull
	@NotEmpty
	private String nomeCurso;
	

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public  Topico converter(CursoRepository cursoRepository) {
		Topico t = new Topico();
		t.setTitulo(getTitulo());
		t.setMensagem(getMensagem());
		t.setCurso(cursoRepository.findByNome(nomeCurso));
		return t;
		
	}

}
