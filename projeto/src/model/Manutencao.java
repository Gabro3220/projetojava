package model;

import java.time.LocalDate;

public class Manutencao {
	private Integer idManutencao;
	private LocalDate dataManutencao;
	private String tipoManutencao;
	private Double custo;
	private String descricao;

	// Relacionamento
	private Veiculo veiculo; // Manutenção está associada a um veículo

	public Manutencao(Integer idManutencao, LocalDate dataManutencao, String tipoManutencao, Double custo, String descricao,
			Veiculo veiculo) {
		this.idManutencao = idManutencao;
		this.dataManutencao = dataManutencao;
		this.tipoManutencao = tipoManutencao;
		this.custo = custo;
		this.descricao = descricao;
		this.veiculo = veiculo;
	}

	

	public Manutencao(Integer idManutencao, LocalDate dataManutencao, String tipoManutencao, Double custo,
			String descricao) {
		super();
		this.idManutencao = idManutencao;
		this.dataManutencao = dataManutencao;
		this.tipoManutencao = tipoManutencao;
		this.custo = custo;
		this.descricao = descricao;
	}



	// Getters e Setters
	public Integer getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(Integer idManutencao) {
		this.idManutencao = idManutencao;
	}

	public LocalDate getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(LocalDate dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getTipoManutencao() {
		return tipoManutencao;
	}

	public void setTipoManutencao(String tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
