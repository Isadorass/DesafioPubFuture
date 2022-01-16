package br.com.isadora.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import br.com.isadora.enums.TipoConta;

/**
 * <h1>Entidade referente a {@link Conta}.</h1>
 * 
 * <p>
 * Está classe possui todos os atributos da entidade {@link Conta}. Está classe
 * foi mapeada com o framework Hibernate para que seja feita uma entidade
 * relacional em um banco de dados.
 * </p>
 * 
 * <p>
 * Esta classe recebe a anotação {@link Entity}, que diz ao Hibernate que esta
 * classe será uma entidade em nosso banco de dados.
 * </p>
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 *
 * @see Conta
 * @see Entity
 */
@Entity
public class Conta {

	/**
	 * <p>
	 * id {@link Integer} - Referente ao Id da {@link Conta}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link GeneratedValue} com o seu parâmetro
	 * strategy. Está anotação determina que esse atributo vai ser gerado
	 * automaticamente com a estratégia {@link GenerationType#AUTO}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo também recebe a anotação {@link Id}, essa anotação diz para o
	 * Hibernate que este atributo será a chave primária da entidade {@link Conta}.
	 * </p>
	 * 
	 * @see Integer
	 * @see Conta
	 * @see GeneratedValue
	 * @see GenerationType#AUTO
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * <p>
	 * saldo {@link Double} - Referente ao saldo da {@link Conta}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link Column}, a anotação {@link Column} diz
	 * ao Hibernate que este atributo será uma coluna da entidade {@link Conta}.
	 * Usamos um parametro {@link Column#length()} para determinar o tamanho deste
	 * atributo no banco de dados.
	 * </p>
	 * 
	 * @see Double
	 * @see Conta
	 * @see NonNull
	 * @see Column
	 * @see Column#length()
	 */
	@NonNull
	@Column(length = 99999999)
	private Double saldo;

	/**
	 * <p>
	 * tipoConta {@link TipoConta} - Referente ao tipo da {@link Conta}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link Column}, a anotação {@link Column} diz
	 * ao Hibernate que este atributo será uma coluna da entidade {@link Conta}.
	 * Usamos um parametro {@link Column#length()} para determinar o tamanho deste
	 * atributo no banco de dados.
	 * </p>
	 * 
	 * @see TipoConta
	 * @see Conta
	 * @see NonNull
	 * @see Column
	 * @see Column#length()
	 */
	@NonNull
	@Column(length = 14)
	private TipoConta tipoConta;

	/**
	 * <p>
	 * instituicaoFinanceira {@link String} - Referente a instituição finaceira da
	 * {@link Conta}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link Column}, a anotação {@link Column} diz
	 * ao Hibernate que este atributo será uma coluna da entidade {@link Conta}.
	 * Usamos um parametro {@link Column#length()} para determinar o tamanho deste
	 * atributo no banco de dados.
	 * </p>
	 * 
	 * @see String
	 * @see Conta
	 * @see NonNull
	 * @see Column
	 * @see Column#length()
	 */
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

	public void setId(Integer id) {
		this.id = id;
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
		return "Conta [id = " + this.id + ", saldo=" + this.saldo + ", tipoConta=" + this.tipoConta
				+ ", instituicaoFinanceira=" + this.instituicaoFinanceira + "]";
	}
}