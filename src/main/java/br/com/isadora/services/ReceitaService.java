package br.com.isadora.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Receita;
import br.com.isadora.enums.TipoReceita;
import br.com.isadora.repositories.ReceitaRepository;
import br.com.isadora.utils.exceptions.ReceitaInexistenteException;

/**
 * Classe de serviço da Receieta
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 * 
 *         Classe responsável por guardar os métodos CRUD da Receita
 *
 */
@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;

	/**
	 * Salva uma conta no bando de dados Recebe uma Receita e salva ela no banco de
	 * dados, retorna o id da mesma no final.
	 * 
	 * @param receita Receita - Receita referente a receita ser salva no banco de
	 *                dados
	 * 
	 * @return Integer - referente ao id da Receita.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */

	public Integer criar(Receita receita) {
		return receitaRepository.save(receita).getId();
	}

	/**
	 * Atualiza uma conta do bando de dados.
	 * 
	 * Recebe uma Receita e atualiza ela no banco de dados, retorna o id da mesma no
	 * final.
	 * 
	 * @param receita Receita - Referente a Receita a ser atualizada no banco de
	 *                dados.
	 * 
	 * @param id      Integer - Referente ao id Receita
	 * 
	 * @return Integer - Referente ao id da Receita
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer atualizar(Receita receita, Integer id) {
		try {
			receita.setId(existeReceita(id).getId());
			return receitaRepository.save(receita).getId();
		} catch (ReceitaInexistenteException exception) {
			System.err.print(exception);
			return 0;
		}
	}

	/**
	 * <h1>Busca todas as receitas</h1>
	 * 
	 * Busca todas as receitas no banco de dados.
	 * 
	 * @return List<{Receita}> - Referente a todas as receitas do banco de dados
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public List<Receita> buscarTodas() {
		return receitaRepository.findAll();
	}

	/**
	 * Busca uma Receita pelo id.
	 * 
	 * Recebe um id e busca a Receita relacionada ao mesmo. Retorna a Receita
	 * encontrada. Caso não a encontre lança uma Exception informando que não foi
	 * encontrado nenhuma Receita.
	 * 
	 * @param id Integer - Referente ao id da Receita a ser pesquisada.
	 * 
	 * @return Receita - Referente a Receita encontrada com esse id.
	 * 
	 * @throws Exception - Informa que não foi encontrado uma Receita com este id.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */

	public Receita buscarPorId(Integer id) {
		try {
			return existeReceita(id);
		} catch (ReceitaInexistenteException exception) {
			System.err.println(exception);
			return null;
		}
	}

	/**
	 * Deleta uma Receita do banco de dados.
	 * 
	 * Recebe um id e deleta a Receita referente a esse id
	 * 
	 * @param id - Integer - Referente ao id da Receita a ser deletada.
	 * 
	 * @return Integer - Referente ao id da Receita que foi deletada.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer deletar(Integer id) {
		receitaRepository.deleteById(id);
		return id;
	}

	/**
	 * <h1>Busca todas as receita de determinado tipo.</h1>
	 * 
	 * Busca todas as reiceitas de determinado tipo do bando de dados.
	 * 
	 * @param tipoReceita TipoReceita - Referente ao tipo de receita que ele irá
	 *                    buscar no banco.
	 * 
	 * @return List <{Receita}> - Referente a todas as receitas encontradas com o
	 *         tipo passado.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public List<Receita> buscarPorTipoReceita(TipoReceita tipoReceita) {
		return receitaRepository.findByTipoReceita(tipoReceita);
	}

	/**
	 * <h1>Lista a quantidade de Receitas.</h1>
	 * 
	 * Lista o total de receitas existentes no banco de dados.
	 * 
	 * @return Integer - Referente ao número de receitas existentes no banco.
	 * 
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer listarTotalDeReceitas() {
		return receitaRepository.findAll().size();
	}

	/**
	 * <h1>Lista todas as receitas por periodo.</h1>
	 * 
	 * Lista todas as receitas por periodo de data de recebimento, periodo entre a
	 * dataInicial e dataFinal.
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
	public List<Receita> buscarPorPeriodoDataRecebimento(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		return receitaRepository.findByDataRecebimentoBetween(dataInicial, dataFinal);
	}

	/**
	 * <h1>Lista todas as receitas por periodo.</h1>
	 * 
	 * Lista todas as receitas por periodo de data de recebimento esperado, periodo
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
	public List<Receita> buscarPorPeriodoDataRecebimentoEsperado(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		return receitaRepository.findByDataRecebimentoEsperadoBetween(dataInicial, dataFinal);
	}

	/**
	 * metodo que verifica se uma receita é existente, caso não, lança uma
	 * exception, caso contrario retorna uma receita
	 * 
	 * @param id Integer - refente ao id da receita
	 * @return Receita - referente a receita
	 * @throws ReceitaInexistenteException - caso uma receita não exista
	 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
	 */
	private Receita existeReceita(Integer id) throws ReceitaInexistenteException {
		Optional<Receita> optionalReceita = receitaRepository.findById(id);
		if (!optionalReceita.isPresent()) {
			throw new ReceitaInexistenteException(id);
		}
		return optionalReceita.get();
	}

}