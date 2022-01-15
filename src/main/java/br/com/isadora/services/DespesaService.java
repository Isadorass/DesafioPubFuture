package br.com.isadora.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Despesa;
import br.com.isadora.repositories.DespesaRepository;

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
	 * 
	 * @return Integer - Referente ao id da Despesa.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer atualizar(Despesa despesa) {
		return despesaRepository.save(despesa).getId();
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
	public Despesa buscarPorId(Integer id) throws Exception {
		Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
		if (optionalDespesa.isPresent()) {
			return optionalDespesa.get();
		}
		throw new Exception("Não foi encontrado uma conta com o id " + id);
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
	public Integer listarTotalDeDespesas() {
		return despesaRepository.findAll().size();
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
	public List<Despesa> buscarPorPeriodoDataRecebimento(LocalDateTime dataInicial, LocalDateTime dataFinal) {
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
	public List<Despesa> buscarPorPeriodoDataRecebimentoEsperado(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		return despesaRepository.findByDataPagamentoEsperadoBetween(dataInicial, dataFinal);
	}
}