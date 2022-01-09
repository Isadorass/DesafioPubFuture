package br.com.isadora.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

import br.com.isadora.enums.TipoDespesa;

@Entity
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@Column(length = 99999999)
	private Double valor;

	@NonNull
	private LocalDateTime dataPagamento;

	@NonNull
	private LocalDateTime dataPagamentoEsperado;

	@NonNull
	@Column(length = 11)
	private TipoDespesa tipoDespesa;

	@NonNull
	@JoinColumn(name = "conta_id")
	@ManyToOne
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

	public Integer getId() {
		return id;
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
		return "Despesa [id = " + this.id + ", valor=" + this.valor + ", dataPagamento=" + this.dataPagamento
				+ ", dataPagamentoEsperado=" + this.dataPagamentoEsperado + ", tipoDespesa=" + this.tipoDespesa
				+ ", conta=" + this.conta + "]";
	}
}