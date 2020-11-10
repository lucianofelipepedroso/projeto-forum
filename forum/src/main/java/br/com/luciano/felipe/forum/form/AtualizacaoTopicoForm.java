package br.com.luciano.felipe.forum.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.luciano.felipe.forum.modelo.Topico;
import br.com.luciano.felipe.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@NotEmpty
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);

		return topico;

	}

}
