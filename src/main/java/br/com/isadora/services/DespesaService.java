package br.com.isadora.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Despesa;
import br.com.isadora.enums.TipoDespesa;
import br.com.isadora.repositories.DespesaRepository;
import br.com.isadora.utils.exceptions.DespesaInexistenteException;

/**
 * <h1>Classe de serviço da {@link Despesa}.</h1>
 * 
 * <p>
 * Classe responsável por guardar os métodos CRUD da {@link Despesa}.
 * </p>
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 * 
 * @see Despesa
 **/
@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	/**
	 * Salva uma Despesa no bando de dados.
	 * 
	 * Recebe uma Despesa e salva ela no banco de dados, retorna o id da mesma no
	 * final.
	 * 
	 * @param despesa Despesa - Referente a Despesa a ser salva no banco de dados.
	 * 
	 * @return Integer - Referente ao id da Despesa.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer criar(Despesa despesa) {
		return despesaRepository.save(despesa).getId();
	}

	/**
	 * Atualiza uma Despesa do bando de dados.
	 * 
	 * Recebe uma Despesa e atualiza ela no banco de dados, retorna o id da mesma no
	 * final.
	 * 
	 * @param despesa Despesa - Referente a Despesa a ser atualizada no banco de
	 *                dados.
	 * @param id      Integer - referente ao id.
	 * 
	 * @return Integer - Referente ao id da Despesa.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer atualizar(Despesa despesa, Integer id) {
		try {
			despesa.setId(existeDespesa(id).getId());
			return despesaRepository.save(despesa).getId();
		} catch (DespesaInexistenteException exception) {
			System.err.print(exception);
			return 0;
		}
	}

	/**
	 * Método que verifica se existe uma despesa, caso sim retorna a despesa, caso
	 * contrario lança uma exception
	 * 
	 * @param id Integer - id referente a despesa
	 * @return Despesa - referente a despesa
	 * @throws DespesaInexistenteException - lança uma exception caso a despesa não
	 *                                     existe
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	private Despesa existeDespesa(Integer id) throws DespesaInexistenteException {
		Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
		if (!optionalDespesa.isPresent()) {
			throw new DespesaInexistenteException(id);
		}
		return optionalDespesa.get();
	}

	/**
	 * <h1>Busca todas as Despesas</h1>
	 * 
	 * Busca todas as Despesas no banco de dados.
	 * 
	 * @return List<{Despesas}> - Referente a todas as Despesas do banco de dados
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public List<Despesa> buscarTodas() {
		return despesaRepository.findAll();
	}

	/**
	 * Busca uma Despesa pelo id.
	 * 
	 * Recebe um id e busca a Despesa relacionada ao mesmo. Retorna a Despesa
	 * encontrada. Caso não a encontre lança uma Exception informando que não foi
	 * encontrado nenhuma Despesa.
	 * 
	 * @param id Integer - Referente ao id da Despesa a ser pesquisada.
	 * 
	 * @return Despesa - Referente a Despesa encontrada com esse id.
	 * 
	 * @throws Exception - Informa que não foi encontrado uma Despesa com este id.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Despesa buscarPorId(Integer id) {
		try {
			return existeDespesa(id);
		} catch (DespesaInexistenteException exception) {
			System.err.print(exception);
			return null;
		}
	}

	/**
	 * Deleta uma Despesa do banco de dados.
	 * 
	 * Recebe um id e deleta a Despesa referente a esse id.
	 * 
	 * @param id Integer - Referente ao id da Despesa a ser deletada.
	 * 
	 * @return Integer - Referente ao id da Despesa que foi deletada.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer deletar(Integer id) {
		despesaRepository.deleteById(id);
		return id;
	}

	/**
	 * <h1>Lista a quantidade de Despesas.</h1>
	 * 
	 * Lista o total de Despesas existentes no banco de dados.
	 * 
	 * @return Integer - Referente ao número de Despesas existentes no banco.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer buscarTotalDeDespesas() {
		return buscarTodas().size();
	}

	/**
	 * <h1>Lista todas as Despesa por periodo.</h1>
	 * 
	 * Lista todas as Despesa por periodo de data de pagamento, periodo entre a
	 * dataInicial e dataFinal.
	 * 
	 * @param dataInicial LocalDateTime - Referente a data de inicio do filtro.
	 * 
	 * @param dataFinal   LocalDateTime - Referente a data final do filtro.
	 * 
	 * @return List <{Receita}> - Referente a todas as Despesa encontradas entre a
	 *         dataInicial e a dataFinal.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public List<Despesa> buscarPorPeriodoDataPagamento(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		return despesaRepository.findByDataPagamentoBetween(dataInicial, dataFinal);
	}

	/**
	 * <h1>Lista todas as Despesa por periodo.</h1>
	 * 
	 * Lista todas as Despesa por periodo de data de pagamento esperado, periodo
	 * entre a dataInicial e dataFinal.
	 * 
	 * @param dataInicial LocalDateTime - Referente a data de inicio do filtro.
	 * 
	 * @param dataFinal   LocalDateTime - Referente a data final do filtro.
	 * 
	 * @return List <{Receita}> - Referente a todas as receitas encontradas entre a
	 *         dataInicial e a dataFinal.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public List<Despesa> buscarPorPeriodoDataPagamentoEsperado(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		return despesaRepository.findByDataPagamentoEsperadoBetween(dataInicial, dataFinal);
	}

	/**
	 * Metodo que lista despesas por tipo das despesas
	 * 
	 * @param tipoDespesa TipoDespesa - referente ao enum com tipos de despesas
	 * 
	 * @return ListDespesa - refente a todas as despesas encontradas
	 */
	public List<Despesa> buscarTipoDespesa(TipoDespesa tipoDespesa) {
		return despesaRepository.findByTipoDespesa(tipoDespesa);
	}

}