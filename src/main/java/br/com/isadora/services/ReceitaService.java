package br.com.isadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Receita;
import br.com.isadora.repositories.ReceitaRepository;

/**
 * Classe de serviço da Receieta
 * 
 * @author Isadora de Souza e Silva 
 * <strong>isadorass1710@gmail.com</strong>
 * 
 * Classe responsável por guardar
 * os métodos CRUD da Receita
 *
 */
@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository; 
	
	/**
	 * Salva uma conta no bando de dados
	 * Recebe uma Receita e
	 * salva ela no banco de dados, retorna
	 * o id da mesma no final.
	 * 
	 * @param receita Receita - Receita referente a 
	 * receita ser salva no banco de dados
	 * 
	 * @return Integer - referente ao id da Receita.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	
	public Integer criar(Receita receita){
		return receitaRepository.save(receita).getId();
	}
	
	/**
	 * Atualiza uma conta do bando de dados.
	 * 
	 * Recebe uma Receita e
	 * atualiza ela no banco de dados, retorna
	 * o id da mesma no final.
	 * 
	 * @param receita Receita - Referente
	 * a Receita a ser atualizada no banco de dados. 
	 * 
	 * @return Integer - Referente
	 * ao id da Receita
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer atualizar(Receita receita) {
		return receitaRepository.save(receita).getId();
	}
	
	/**
	 * Busca uma Receita pelo id.
	 * 
	 * Recebe um id e busca a
	 * Receita relacionada
	 * ao mesmo. Retorna a Receita
	 * encontrada. Caso não a encontre
	 * lança uma Exception informando
	 * que não foi encontrado nenhuma
	 * Receita.
	 * 
	 * @param id Integer - Referente
	 * ao id da Receita a ser pesquisada.
	 * 
	 * @return Receita - Referente
	 * a Receita encontrada com esse id.
	 * 
	 * @throws Exception - Informa
	 * que não foi encontrado uma Receita
	 * com este id.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	
	public Receita buscarPorId(Integer id) throws Exception {
		Optional<Receita> optionalReceita = receitaRepository.findById(id);
		if(optionalReceita.isPresent()) {
			return optionalReceita.get();
		}
		throw new Exception("Não foi encontrado uma conta com o id " + id);
	}
	
	/**
	 * Deleta uma Receita do banco de dados.
	 * 
	 * Recebe um id e deleta a
	 * Receita referente a
	 * esse id
	 * 
	 * @param id - Integer - Referente
	 * ao id da Receita a ser deletada.
	 * 
	 * @return Integer - Referente
	 * ao id da Receita que foi deletada.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer deletar(Integer id) {
		receitaRepository.deleteById(id);
		return id;
	}
}
