package br.com.luciano.felipe.forum.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.luciano.felipe.forum.modelo.Topico;

public class TopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;

	public TopicoDto(Topico t) {
		this.id = t.getId();
		this.titulo = t.getTitulo();
		this.mensagem = t.getMensagem();
		this.dataCriacao = t.getDataCriacao();
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<TopicoDto> converter(Page<Topico> topicos) {

		//topicos.stream().map(TopicoDto::new).collect(Collectors.toList());

//		List<TopicoDto> dtos = new ArrayList<TopicoDto>();
//		for (Topico t : topicos) {
//			dtos.add(new TopicoDto(t));
//		}

		return topicos.map(TopicoDto::new);

	}

}
