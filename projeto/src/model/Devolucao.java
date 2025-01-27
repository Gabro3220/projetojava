package model;

import java.time.LocalDate;

public class Devolucao extends Locacao {
	private LocalDate dataDevolucao;
	private String condicaoVeiculo;
	private Double taxaAtraso;
	private Boolean statusDevolucao;



	public Devolucao(Integer idLocacao, LocalDate dataLocacao, LocalDate dataDevolucaoPrevista,
			LocalDate dataDevolucaoReal, Double valorTotal, String tipoLocacao, String observacoes, Cliente cliente,
			Veiculo veiculo, Fatura fatura, LocalDate dataDevolucao, String condicaoVeiculo, Double taxaAtraso,
			Boolean statusDevolucao) {
		super(idLocacao, dataLocacao, dataDevolucaoPrevista, dataDevolucaoReal, valorTotal, tipoLocacao, observacoes,
				cliente, veiculo, fatura);
		this.dataDevolucao = dataDevolucao;
		this.condicaoVeiculo = condicaoVeiculo;
		this.taxaAtraso = taxaAtraso;
		this.statusDevolucao = statusDevolucao;
	}

	
	

	











	public Devolucao(LocalDate dataDevolucao, String condicaoVeiculo, Double taxaAtraso, Boolean statusDevolucao) {
		super();
		this.dataDevolucao = dataDevolucao;
		this.condicaoVeiculo = condicaoVeiculo;
		this.taxaAtraso = taxaAtraso;
		this.statusDevolucao = statusDevolucao;
	}





























	// Getters e setters
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getCondicaoVeiculo() {
		return condicaoVeiculo;
	}

	public void setCondicaoVeiculo(String condicaoVeiculo) {
		this.condicaoVeiculo = condicaoVeiculo;
	}

	public Double getTaxaAtraso() {
		return taxaAtraso;
	}

	public void setTaxaAtraso(Double taxaAtraso) {
		this.taxaAtraso = taxaAtraso;
	}

	public Boolean getStatusDevolucao() {
		return statusDevolucao;
	}

	public void setStatusDevolucao(Boolean statusDevolucao) {
		this.statusDevolucao = statusDevolucao;
	}
}
