package br.com.isadora.utils.exceptions;

/**
 * Classe que verifica valores negativos
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 *
 */
public class ValorNegativoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValorNegativoException() {
		super("Esse valor é negativo.");
	}
}