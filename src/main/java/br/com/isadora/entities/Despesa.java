package br.com.isadora.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

import br.com.isadora.enums.TipoDespesa;

/**
 * <h1>Entidade referente a {@link Despesa}.</h1>
 * 
 * <p>
 * Está classe possui todos os atributos da entidade {@link Despesa}. Está
 * classe foi mapeada com o framework Hibernate para que seja feita uma entidade
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
 * @see Despesa
 * @see Entity
 */
@Entity
public class Despesa {

	/**
	 * <p>
	 * id {@link Integer} - Referente ao id da {@link Despesa}.
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
	 * Hibernate que este atributo será a chave primária da entidade
	 * {@link Despesa}.
	 * </p>
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Integer
	 * @see Despesa
	 * @see GeneratedValue
	 * @see GenerationType#AUTO
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * <p>
	 * valor {@link Double} - Referente ao valor da {@link Despesa}
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link Column}, a anotação {@link Column} diz
	 * ao Hibernate que este atributo será uma coluna da entidade {@link Despesa}.
	 * Usamos um parametro {@link Column#length()} para determinar o tamanho deste
	 * atributo no banco de dados.
	 * </p>
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Double
	 * @see Despesa
	 * @see NonNull
	 * @see Column
	 * @see Column#length()
	 */
	@NonNull
	@Column(length = 99999999)
	private Double valor;

	/**
	 * <p>
	 * dataPagamento {@link LocalDateTime} - Referente a data de pagamento da
	 * {@link Despesa}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see LocalDateTime
	 * @see Despesa
	 * @see NonNull
	 */
	@NonNull
	private LocalDateTime dataPagamento;

	/**
	 * <p>
	 * dataPagamentoEsperado {@link LocalDateTime} - Referente a data de pagamento
	 * esperado da {@link Despesa}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see LocalDateTime
	 * @see Despesa
	 * @see NonNull
	 */
	@NonNull
	private LocalDateTime dataPagamentoEsperado;

	/**
	 * <p>
	 * tipoDespesa {@link TipoDespesa} - Referente ao tipo da {@link Despesa}.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link Column}, a anotação {@link Column} diz
	 * ao Hibernate que este atributo será uma coluna da entidade {@link Despesa}.
	 * Usamos um parametro {@link Column#length()} para determinar o tamanho deste
	 * atributo no banco de dados.
	 * </p>
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see TipoDespesa
	 * @see Despesa
	 * @see NonNull
	 * @see Column
	 * @see Column#length()
	 */
	@NonNull
	@Column(length = 11)
	private TipoDespesa tipoDespesa;

	/**
	 * <p>
	 * conta {@link Conta} - Referente a {@link Conta} vinculada a esta
	 * {@link Despesa}
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link NonNull}, que diz ao Hibernate que
	 * este atributo não poderá ser salvo como nulo no banco de dados.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link JoinColumn}, que diz ao Hibernate que
	 * este atributo é uma coluna de relacionamento, usamos seu parâmetro
	 * {@link JoinColumn#name()} para definirmos o nome da coluna no banco de dados.
	 * </p>
	 * 
	 * <p>
	 * Este atributo recebe a anotação {@link ManyToOne}, que diz ao Hibernate que
	 * este atributo é uma relação com está classe({@link Despesa}). A relação feita
	 * neste atributo é de 1 para N ou OneToMany, onde many é a entidade
	 * {@link Despesa} e one é a entidade {@link Conta}.
	 * </p>
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Despesa
	 * @see NonNull
	 * @see JoinColumn
	 * @see JoinColumn#name()
	 * @see ManyToOne
	 */
	@NonNull
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

	public Despesa() {

	}

	public Despesa(Double valor, LocalDateTime dataPagamento, LocalDateTime dataPagamentoEsperado,
			TipoDespesa tipoDespesa, Conta conta) {
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.tipoDespesa = tipoDespesa;
		this.conta = conta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public LocalDateTime getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public void setDataPagamentoEsperado(LocalDateTime dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String toString() {
		return "Despesa [id = " + this.id + ", valor=" + this.valor + ", dataPagamento=" + this.dataPagamento
				+ ", dataPagamentoEsperado=" + this.dataPagamentoEsperado + ", tipoDespesa=" + this.tipoDespesa
				+ ", conta=" + this.conta + "]";
	}
}