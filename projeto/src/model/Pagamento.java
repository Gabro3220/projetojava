package model;

public class Pagamento {
	private String idPagamento;
	private Double valor;
	private String metodoPagamento;
	private String dataPagamento;
	private String status;
	private String descricao;

	// Relacionamento
	private Fatura fatura; // Pagamento está vinculado a uma fatura

	public Pagamento(String idPagamento, Double valor, String metodoPagamento, String dataPagamento, String status,
			String descricao, Fatura fatura) {
		this.idPagamento = idPagamento;
		this.valor = valor;
		this.metodoPagamento = metodoPagamento;
		this.dataPagamento = dataPagamento;
		this.status = status;
		this.descricao = descricao;
		this.fatura = fatura;
	}

	public Pagamento(String idPagamento, Double valor, String metodoPagamento, String dataPagamento, String status,
			String descricao) {
		super();
		this.idPagamento = idPagamento;
		this.valor = valor;
		this.metodoPagamento = metodoPagamento;
		this.dataPagamento = dataPagamento;
		this.status = status;
		this.descricao = descricao;
	}

	// Getters e Setters
	public String getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
}
