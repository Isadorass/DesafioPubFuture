package br.com.isadora.enums;

import br.com.isadora.entities.Despesa;

/**
 * <h1>Enum com todos os tipos de {@link Despesa}.</h1>
 * 
 * <p>Enum com todos os
 * valores possíveis para
 * o tipo de uma {@link Despesa}.</p>
 * 
 * <table border = 1>
 *  <tr>
 *   <td>Tipo da Conta</td>  
 *  </tr>
 *  
 *  <tr>
 *   <td>ALIMENTACAO</td>
 *  </tr>
 *  
 *  <tr>
 *   <td>EDUCACAO</td>
 *  </tr>
 *  
 *  <tr>
 *   <td>LAZER</td>
 *  </tr>
 *  	 
 *  <tr>
 *   <td>MORADIA</td>
 *  </tr>	
 *   
 *  <tr>
 *   <td>ROUPA</td>
 *  </tr>	
 *   
 *  <tr>
 *   <td>SAUDE</td>
 *  </tr>
 *  	 
 *  <tr>
 *   <td>TRANSPORTE</td>
 *  </tr>	
 *   
 *  <tr>
 *   <td>OUTROS</td>
 *  </tr>	 
 * </table>
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 * 
 * @see Despesa
 */
public enum TipoDespesa {
	ALIMENTACAO,
	EDUCACAO,
	LAZER,
	MORADIA,
	ROUPA,
	SAUDE,
	TRANSPORTE,
	OUTROS
}