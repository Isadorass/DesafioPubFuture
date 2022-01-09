package br.com.isadora.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import br.com.isadora.enums.TipoConta;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@Column(length = 99999999)
	private Double saldo;

	@NonNull
	@Column(length = 14)
	private TipoConta tipoConta;

	@NonNull
	@Column(length = 255)
	private String instituicaoFinanceira;

	public Conta() {
	}

	public Conta(Double saldo, TipoConta tipoConta, String instituicaoFinanceira) {
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public Integer getId() {
		return id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public String toString() {
		return "Conta [id = " + this.id + ", saldo=" + this.saldo + ", tipoConta=" + this.tipoConta + ", instituicaoFinanceira="
				+ this.instituicaoFinanceira + "]";
	}
}