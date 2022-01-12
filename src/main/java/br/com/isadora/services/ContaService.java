package br.com.isadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Conta;
import br.com.isadora.repositories.ContaRepository;

/**
 * <h1>Classe de serviço da {@link Conta}.</h1>
 * 
 * <p> {@link Conta}.</p>
 * 
 * Classe responsável por guardar
 * os métodos CRUD da Despesa
 * 
 * @author Isadora de Souza e Silva 
 * <strong>isadorass1710@gmail.com</strong>
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
	 * <p>Recebe uma {@link Conta} e
	 * salva ela no banco de dados, retorna
	 * o id da mesma no final.</p>
	 * 
	 * @param conta {@link Conta} - Referente
	 * a conta a ser salva no banco de dados.
	 * 
	 * @return {@link Integer} - Referente
	 * ao id da {@link Conta}.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
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
	 * <p>Recebe uma {@link Conta} e
	 * atualiza ela no banco de dados, retorna
	 * o id da mesma no final.</p>
	 * 
	 * @param conta {@link Conta} - Referente
	 * a conta a ser atualizada no banco de dados.
	 * 
	 * @return {@link Integer} - Referente
	 * ao id da {@link Conta}.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Integer
	 */
	public Integer atualizar(Conta conta) {
		return contaRepository.save(conta).getId();
	}

	/**
	 * <h1>Busca uma {@link Conta} pelo id.</h1>
	 * 
	 * <p>Recebe um id e busca a
	 * {@link Conta} relacionada
	 * ao mesmo. Retorna a {@link Conta}
	 * encontrada. Caso não a encontre
	 * lança um {@link Exception} informando
	 * que não foi encontrado nenhuma
	 * {@link Conta}.</p>
	 * 
	 * @param id {@link Integer} - Referente
	 * ao id da {@link Conta} a ser pesquisada.
	 * 
	 * @return {@link Conta} - Referente
	 * a conta encontrada com esse id.
	 * 
	 * @throws {@link Exception} - Informa
	 * que não foi encontrado uma {@link Conta}
	 * com este id.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 * 
	 * @see Conta
	 * @see Exception
	 * @see Integer
	 */
	public Conta buscarPorId(Integer id) throws Exception {
		Optional<Conta> optional = contaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new Exception("Não foi encontrado uma conta com o id " + id);
	}

	/**
	 * <h1>Deleta uma {@link Conta} do banco de dados.</h1>
	 * 
	 * <p>Recebe um id e deleta a
	 * {@link Conta} referente a
	 * esse id.</p>
	 * 
	 * @param id {@link Integer} - Referente
	 * ao id da {@link Conta} a ser deletada.
	 * 
	 * @return {@link Integer} - Referente
	 * ao id da {@link Conta} que foi deletada.
	 * 
	 * @author Isadora de Souza e Silva 
	 * <strong>isadorass1710@gmail.com</strong>
	 */
	public Integer deletar(Integer id) {
		contaRepository.deleteById(id);
		return id;
	}
}