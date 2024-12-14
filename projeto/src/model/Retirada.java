package model;

import java.time.LocalDateTime;

public class Retirada {
	private LocalDateTime dataRetirada;
	private String localRetirada;
	private Boolean documentosVerificados;
	private String statusRetirada;

	// Relacionamento
	

	public Retirada(LocalDateTime dataRetirada, String localRetirada, Boolean documentosVerificados, String statusRetirada) {
		this.dataRetirada = dataRetirada;
		this.localRetirada = localRetirada;
		this.documentosVerificados = documentosVerificados;
		this.statusRetirada = statusRetirada;
	
	}

	public Retirada() {
	}

	

	// Getters e Setters
	public LocalDateTime getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getLocalRetirada() {
		return localRetirada;
	}

	public void setLocalRetirada(String localRetirada) {
		this.localRetirada = localRetirada;
	}

	public Boolean getDocumentosVerificados() {
		return documentosVerificados;
	}

	public void setDocumentosVerificados(Boolean documentosVerificados) {
		this.documentosVerificados = documentosVerificados;
	}

	public String getStatusRetirada() {
		return statusRetirada;
	}

	public void setStatusRetirada(String statusRetirada) {
		this.statusRetirada = statusRetirada;
	}

	
}
