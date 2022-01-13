package br.com.isadora.utils.validation;

import br.com.isadora.entities.Conta;

public class ContaValidation {
	
	private ContaValidation() {
	}
	
	/**
	 * <h1>Verifica o saldo de uma {@link Conta}.</h1>
	 * 
	 * <p>
	 * Verifica o saldo da {@link Conta} a partir do valor passado. Retorna true
	 * caso o saldo da conta for igual ou maior ao valor informado.
	 * </p>
	 * 
	 * @param conta {@link Conta} - Referente a conta que será verificado o saldo.
	 * 
	 * @param valor {@link Double} - Referente ao valor a ser verificado.
	 * 
	 * @return {@link Boolean} - true caso o saldo for válido e false caso
	 *         contrário.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Double
	 * @see Boolean
	 */
	public static Boolean verificaSaldo(Conta conta, Double valor) {
		return conta.getSaldo() >= valor;
	}	
}