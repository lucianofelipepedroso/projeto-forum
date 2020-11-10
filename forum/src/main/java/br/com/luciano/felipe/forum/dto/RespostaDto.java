package br.com.luciano.felipe.forum.dto;

import java.time.LocalDateTime;

import br.com.luciano.felipe.forum.modelo.Resposta;

public class RespostaDto {

	private Long id;

	private String mensagem;

	private LocalDateTime dataDaCriacao;

	private String nomeAutor;

	public RespostaDto(Resposta resposta) {

		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
		this.dataDaCriacao = resposta.getDataCriacao();
		this.nomeAutor = resposta.getAutor().getNome();

	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataDaCriacao() {
		return dataDaCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

}
