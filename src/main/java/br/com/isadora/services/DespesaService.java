package br.com.isadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Conta;
import br.com.isadora.entities.Despesa;
import br.com.isadora.repositories.DespesaRepository;

/**
 * Classe de serviço da Despesa.
 * 
 * Classe responsável por guardar
 * os métodos CRUD da Despesa
 * 
 * @author Isadora de Souza e Silva 
 * <strong>isadorass1710@gmail.com</strong>
 *  
 **/
@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	/**
	 * Salva uma Despesa no bando de dados.
	 * 
	 * Recebe uma Despesa e salva ela no 
	 * banco de dados, retorna o id da mesma no
	 * final.
	 * 
	 * @param despesa Despesa -  Referente
	 * a Despesa a ser salva no banco de dados.
	 * 
	 * @return Integer -  Referente
	 * ao id da Despesa.
	 * 
	 *  @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer criar(Despesa despesa) {
		return despesaRepository.save(despesa).getId();
	}

	/**
	 * Atualiza uma Despesa do bando de dados.
	 * 
	 * Recebe uma Despesa e
	 * atualiza ela no banco de dados, retorna
	 * o id da mesma no final.
	 * 
	 * @param despesa Despesa - Referente
	 * a Despesa a ser atualizada no banco de dados.
	 * 
	 * @return Integer - Referente
	 * ao id da Despesa.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer atualizar(Despesa despesa) {
		return despesaRepository.save(despesa).getId();
	}

	/**
	 * Busca uma Despesa pelo id.
	 * 
	 * Recebe um id e busca a
	 * Despesa relacionada
	 * ao mesmo. Retorna a Despesa
	 * encontrada. Caso não a encontre
	 * lança uma Exception informando
	 * que não foi encontrado nenhuma
	 * Despesa.
	 * 
	 * @param id Integer - Referente
	 * ao id da Despesa a ser pesquisada.
	 * 
	 * @return Despesa - Referente
	 * a Despesa encontrada com esse id.
	 * 
	 * @throws Exception - Informa
	 * que não foi encontrado uma Despesa
	 * com este id.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
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
	 * Recebe um id e deleta a
	 * Despesa referente a
	 * esse id.
	 * 
	 * @param id Integer - Referente
	 * ao id da Despesa a ser deletada. 
	 * 
	 * @return Integer - Referente
	 * ao id da Despesa que foi deletada.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer deletar(Integer id) {
		despesaRepository.deleteById(id);
		return id;
	}
}
