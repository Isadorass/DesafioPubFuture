package br.com.isadora.utils.validations;

import br.com.isadora.entities.Conta;

/**
 * <h1>Classe de validações da conta</h1>
 * 
 * Classe responsavel por todas as validações dos metodos de serviço da Conta
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 *
 */
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
	 * @param conta {@link Conta} - Referente a {@link Conta} que será verificado o
	 *              saldo.
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

	/**
	 * Verifica se um valor é negativo
	 * 
	 * @param valor Double - valor a ser verificado
	 * 
	 * @return Boolean - caso retorne true o valor é negativo
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public static Boolean verificarValorNegativo(Double valor) {
		return valor <= 0;
	}
}