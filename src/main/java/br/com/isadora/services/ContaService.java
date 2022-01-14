package br.com.isadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Conta;
import br.com.isadora.repositories.ContaRepository;
import br.com.isadora.utils.exceptions.ContaInexistenteException;
import br.com.isadora.utils.exceptions.ValorNegativoException;
import br.com.isadora.utils.validations.ContaValidation;

/**
 * <h1>Classe de serviço da {@link Conta}.</h1>
 * 
 * <p>
 * {@link Conta}.
 * </p>
 * 
 * Classe responsável por guardar os métodos CRUD da Despesa
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 *
 * @see Conta
 */
@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	/**
	 * <h1>Salva uma conta no bando de dados.</h1>
	 * 
	 * <p>
	 * Recebe uma {@link Conta} e salva ela no banco de dados, retorna o id da mesma
	 * no final.
	 * </p>
	 * 
	 * @param conta {@link Conta} - Referente a conta a ser salva no banco de dados.
	 * 
	 * @return {@link Integer} - Referente ao id da {@link Conta}.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Integer
	 */
	public Integer criar(Conta conta) {
		return contaRepository.save(conta).getId();
	}

	/**
	 * <h1>Atualiza uma conta do bando de dados.</h1>
	 * 
	 * <p>
	 * Recebe uma {@link Conta} e atualiza ela no banco de dados, retorna o id da
	 * mesma no final.
	 * </p>
	 * 
	 * @param conta {@link Conta} - Referente a conta a ser atualizada no banco de
	 *              dados.
	 * 
	 * @return {@link Integer} - Referente ao id da {@link Conta}.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Integer
	 */
	public Integer atualizar(Conta conta) {
		return contaRepository.save(conta).getId();
	}

	/**
	 * <h1>Busca todas as {@link Conta}s.</h1>
	 * 
	 * <p>
	 * Busca todas as {@link Conta}s do banco de dados.
	 * </p>
	 *
	 * @return {@link List}<{@link Conta}> - Referente a todas as contas no banco de
	 *         dados.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see List
	 */
	public List<Conta> buscarTodasContas() {
		return contaRepository.findAll();
	}

	/**
	 * <h1>Busca uma {@link Conta} pelo id.</h1>
	 * 
	 * <p>
	 * Recebe um id e busca a {@link Conta} relacionada ao mesmo. Retorna a
	 * {@link Conta} encontrada.
	 * </p>
	 * 
	 * @param id {@link Integer} - Referente ao id da {@link Conta} a ser
	 *           pesquisada.
	 * 
	 * @return {@link Conta} - Referente a conta encontrada com esse id.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Exception
	 * @see Integer
	 */
	public Conta buscarPorId(Integer id) throws ContaInexistenteException {
		try {
			return existeConta(id);
		} catch (Exception exception) {
			System.err.println(exception);
			return new Conta();
		}
	}

	/**
	 * <h1>Deleta uma {@link Conta} do banco de dados.</h1>
	 * 
	 * <p>
	 * Recebe um id e deleta a {@link Conta} referente a esse id.
	 * </p>
	 * 
	 * @param id {@link Integer} - Referente ao id da {@link Conta} a ser deletada.
	 * 
	 * @return {@link Integer} - Referente ao id da {@link Conta} que foi deletada.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer deletar(Integer id) {
		contaRepository.deleteById(id);
		return id;
	}

	/**
	 * <h1>Lista o saldo de uma {@link Conta}.</h1>
	 * 
	 * <p>
	 * Lista o saldo de uma {@link Conta} apartir do id da mesma.
	 * </p>
	 * 
	 * @param id {@link Integer} - Referente ao id da {@link Conta}.
	 * 
	 * @return {@link Double} - Referente ao saldo da {@link Conta}.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Integer
	 * @see Double
	 */
	public Double listarSaldo(Integer id) {
		try {
			return existeConta(id).getSaldo();
		} catch (Exception exception) {
			System.err.println(exception);
			return -0.0;
		}
	}

	/**
	 * <h1>Transfere o saldo entre duas {@link Conta}s.</h1>
	 * 
	 * <p>
	 * Recebe o id de duas {@link Conta}s e um valor referente ao valor da
	 * transferência entre elas. Verifica a existência das duas {@link Conta}s e
	 * executa a transferencia caso elas existam.
	 * </p>
	 * 
	 * @param idContaPagante     {@link Integer} - Referente ao id da {@link Conta}
	 *                           onde será feito o débito do valor.
	 * 
	 * @param idContaRecebente   {@link Integer} - Referente ao id da {@link Conta}
	 *                           onde será feito o crédito do valor.
	 * 
	 * @param valorTransferencia {@link Double} - Referente ao valor da
	 *                           transferência.
	 * 
	 * @return {@link Boolean} - true caso a transferência tenha ocorrido com
	 *         sucesso e false caso contrário.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Integer
	 * @see Double
	 * @see Boolean
	 */
	public Boolean transferirSaldo(Integer idContaPagante, Integer idContaRecebente, Double valorTransferencia) {
		try {
			Conta contaPagante = existeConta(idContaPagante);
			Conta contaRecebente = existeConta(idContaRecebente);
			verificaValorTransferencia(valorTransferencia);

			return transferir(contaPagante, contaRecebente, valorTransferencia);
		} catch (Exception exception) {
			System.err.println(exception);
			return false;
		}
	}

	/**
	 * <h1>Verifica o valor da transferência.</h1>
	 * 
	 * <p>Verifica se o valor da transferência
	 * é menor que 0, se for lança uma {@link ValorNegativoException}.</p>
	 * 
	 * @return Boolean - true caso o valor for válido
	 * 
	 * @throws {@link ValorNegativoException} - Lançado
	 * caso o valor seja negativo.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see ValorNegativoException
	 */
	private void verificaValorTransferencia(Double valor) throws ValorNegativoException{
		if (ContaValidation.verificarValorNegativo(valor)) {
			throw new ValorNegativoException();
		}
	}

	/**
	 * <h1>Verica a existência de uma {@link Conta}.</h1>
	 * 
	 * <p>
	 * Recebe o id de uma {@link Conta} e verifica a existência dessa {@link Conta},
	 * lança um {@link Exception} caso o id seja inexistênte ou retorna a
	 * {@link Conta} referente ao id caso ela exista.
	 * </p>
	 * 
	 * @param id {@link Integer} - Referente ao id da {@link Conta}.
	 * 
	 * @return {@link Conta} - Referente a {@link Conta} encontrado com o id
	 *         informado.
	 * 
	 * @throws {@link Exception} - Lança uma {@link Exception} caso o id da conta
	 *                seja inexistente.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Exception
	 * @see Integer
	 */
	private Conta existeConta(Integer id) throws ContaInexistenteException {
		Optional<Conta> optionalConta = contaRepository.findById(id);
		if (!optionalConta.isPresent())
			throw new ContaInexistenteException(id);
		return optionalConta.get();
	}

	/**
	 * <h1>Transfere um valor entre duas {@link Conta}s.</h1>
	 * 
	 * <p>
	 * Recebe duas {@link Conta}s e um valor, desconta esse valor do saldo da
	 * contaPagante e adiciona o mesmo valor no saldo da contaRecebente.
	 * </p>
	 * 
	 * @param contaPagante   {@link Conta} - Referente a {@link Conta} onde será
	 *                       feita o débito do valor.
	 * 
	 * @param contaRecebente {@link Conta} - Referente a {@link Conta} onde será
	 *                       feita o crédito do valor.
	 * 
	 * @param valor          {@link Double} - Referente ao valor da transferência.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Double
	 */
	private Boolean transferir(Conta contaPagante, Conta contaRecebente, Double valor) {
		Double saldoPagante = contaPagante.getSaldo();
		Double saldoRecebente = contaRecebente.getSaldo();

		if (ContaValidation.verificaSaldo(contaPagante, valor)) {
			contaPagante.setSaldo(saldoPagante - valor);
			contaRecebente.setSaldo(saldoRecebente + valor);

			atualizar(contaRecebente);
			atualizar(contaPagante);
			return true;
		}
		return false;
	}
}