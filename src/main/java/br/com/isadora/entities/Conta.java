package br.com.isadora.entities;

import br.com.isadora.enums.TipoConta;

public class Conta {

	private Double saldo;

	private TipoConta tipoConta;

	private String instituicaoFinanceira;

	public Conta() {
	}

	public Conta(Double saldo, TipoConta tipoConta, String instituicaoFinanceira) {
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
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
		return "Conta [saldo=" + saldo + ", tipoConta=" + tipoConta + ", instituicaoFinanceira=" + instituicaoFinanceira
				+ "]";
	}
}