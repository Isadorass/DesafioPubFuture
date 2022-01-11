package br.com.isadora.enums;

import br.com.isadora.entities.Conta;

/**
 * <h1>Enum com todos os tipos de {@link Conta}.</h1>
 * 
 * <p>Enum com todos os
 * valores possíveis para
 * o tipo de uma {@link Conta}.</p>
 * 
 * <table border = 1>
 *  <tr>
 *   <td>Tipo da Conta</td>  
 *  </tr>
 *  
 *  <tr>
 *   <td>CARTEIRA</td>
 *  </tr>
 *  
 *  <tr>
 *   <td>CONTA_CORRENTE</td>
 *  </tr>
 *  
 *  <tr>
 *   <td>POUPANCA</td>
 *  </tr>	 
 * </table>
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 * 
 * @see Conta
 */
public enum TipoConta {
	CARTEIRA, 
	CONTA_CORRENTE, 
	POUPANCA
}