package br.com.isadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Conta;
import br.com.isadora.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public Integer criar(Conta conta) {
		return contaRepository.save(conta).getId();
	}

	public Integer atualizar(Conta conta) {
		return contaRepository.save(conta).getId();
	}

	public Conta buscarPorId(Integer id) throws Exception {
		Optional<Conta> optional = contaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new Exception("Não foi encontrado uma conta com o id " + id);
	}

	public Integer deletar(Integer idConta) {
		contaRepository.deleteById(idConta);
		return idConta;
	}
}