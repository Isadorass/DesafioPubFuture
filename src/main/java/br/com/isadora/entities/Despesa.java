package br.com.isadora.entities;

import java.time.LocalDateTime;

import br.com.isadora.enums.TipoDespesa;

public class Despesa {
	private Double valor;
	private LocalDateTime dataPagamento;
	private LocalDateTime dataPagamentoEsperado;
	private TipoDespesa tipoDespesa;
	private Conta conta;

	public Despesa() {

	}

	public Despesa(Double valor, LocalDateTime dataPagamento, LocalDateTime dataPagamentoEsperado,
			TipoDespesa tipoDespesa, Conta conta) {
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.tipoDespesa = tipoDespesa;
		this.conta = conta;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public LocalDateTime getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public void setDataPagamentoEsperado(LocalDateTime dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String toString() {
		return "Despesa [valor=" + valor + ", dataPagamento=" + dataPagamento + ", dataPagamentoEsperado="
				+ dataPagamentoEsperado + ", tipoDespesa=" + tipoDespesa + ", conta=" + conta + "]";
	}	
}