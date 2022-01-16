package br.com.isadora.utils.exceptions;

/**
 * Classe de Exception quando a despesa for inexistente.
 * 
 * 
 * Classe referente a lançar uma exceção quando a conta for inexistente.
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 *
 */
public class DespesaInexistenteException extends Exception {

	private static final long serialVersionUID = 487120947080082841L;

	public DespesaInexistenteException(Integer id) {
		super("Não foi encontrado uma despesa com o id: " + id);
	}
}
