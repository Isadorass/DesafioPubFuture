package br.com.isadora.utils.exceptions;

/**
 * <h1>Classe de Exception quando a conta for inexistente.</h1>
 * 
 * <p>
 * Classe referente a lançar uma exceção
 * quando a conta for inexistente.
 * </p>
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 */
public class ContaInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContaInexistenteException(Integer id) {
		super("Não foi encontrado uma conta com o id: " + id);
	}
}