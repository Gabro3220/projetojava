package model;

public class Fidelidade {
	private String idFidelidade;
	private Integer pontos;
	private String nivel;
	private String dataUltimaAtualizacao;

	// Construtor completo
	public Fidelidade(String idFidelidade, Integer pontos, String nivel, String dataUltimaAtualizacao) {
		this.idFidelidade = idFidelidade;
		this.pontos = pontos;
		this.nivel = nivel;
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	// Construtor vazio
	public Fidelidade() {
	}

	// Getters e setters
	public String getIdFidelidade() {
		return idFidelidade;
	}

	public void setIdFidelidade(String idFidelidade) {
		this.idFidelidade = idFidelidade;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
}
