package br.com.isadora.entities;

import java.time.LocalDateTime;

import br.com.isadora.enums.TipoReceita;

public class Receitas {
	private Double valor;
	private LocalDateTime dataRecebimento;
	private LocalDateTime dataRecebimentoEsperado;
	private String descricao;
	private Conta conta;
	private TipoReceita tipoReceita;
	
	public Receitas() {
		
	}

	public Receitas(Double valor, LocalDateTime dataRecebimento, LocalDateTime dataRecebimentoEsperado,
			String descricao, Conta conta, TipoReceita tipoReceita) {
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.conta = conta;
		this.tipoReceita = tipoReceita;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDateTime dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public LocalDateTime getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}

	public void setDataRecebimentoEsperado(LocalDateTime dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String toString() {
		return "Receitas [valor=" + valor + ", dataRecebimento=" + dataRecebimento + ", dataRecebimentoEsperado="
				+ dataRecebimentoEsperado + ", descricao=" + descricao + ", conta=" + conta + ", tipoReceita="
				+ tipoReceita + "]";
	}
}