package br.com.luciano.felipe.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.luciano.felipe.forum.modelo.StatusTopico;
import br.com.luciano.felipe.forum.modelo.Topico;

public class DetalhesTopicoDto {

	private Long id;

	private String titulo;

	private String mensagem;

	private LocalDateTime dataDaCriacao;

	private String nomeAutor;

	private StatusTopico status;

	private List<RespostaDto> respostasDto;

	public DetalhesTopicoDto(Topico topico) {

		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataDaCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		respostasDto = new ArrayList<RespostaDto>();
		respostasDto.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));

	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
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

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostasDto() {
		return respostasDto;
	}

}
