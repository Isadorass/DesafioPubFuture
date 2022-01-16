package br.com.isadora.utils.exceptions;

/**
 * Classe de Exception quando a receita for inexistente. Classe referente a
 * lançar uma exceção quando a receita for inexistente.
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 *
 */
public class ReceitaInexistenteException extends Exception {

	private static final long serialVersionUID = -3342035043960364979L;

	public ReceitaInexistenteException(Integer id) {
		super("Não foi encontrado uma receita com o id: " + id);
	}

}
