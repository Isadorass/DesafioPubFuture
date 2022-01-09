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

import br.com.isadora.enums.TipoReceita;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@Column(length = 999999999)
	private Double valor;

	@NonNull
	private LocalDateTime dataRecebimento;

	@NonNull
	private LocalDateTime dataRecebimentoEsperado;

	@NonNull
	@Column(length = 255)
	private String descricao;

	@NonNull
	@Column(length = 8)
	private TipoReceita tipoReceita;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

	public Receita() {

	}

	public Receita(Double valor, LocalDateTime dataRecebimento, LocalDateTime dataRecebimentoEsperado,
			String descricao, Conta conta, TipoReceita tipoReceita) {
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.conta = conta;
		this.tipoReceita = tipoReceita;
	}

	public Integer getId() {
		return id;
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
		return "Receitas [id = " + this.id + ", valor=" + this.valor + ", dataRecebimento=" + this.dataRecebimento
				+ ", dataRecebimentoEsperado=" + this.dataRecebimentoEsperado + ", descricao=" + this.descricao
				+ ", conta=" + this.conta + ", tipoReceita=" + this.tipoReceita + "]";
	}
}