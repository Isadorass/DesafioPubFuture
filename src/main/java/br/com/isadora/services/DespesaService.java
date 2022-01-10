package br.com.isadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Despesa;
import br.com.isadora.repositories.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	public Integer criar(Despesa despesa) {
		return despesaRepository.save(despesa).getId();
	}

	public Integer atualizar(Despesa despesa) {
		return despesaRepository.save(despesa).getId();
	}
	
	public Despesa buscarPorId(Integer id) throws Exception {
		Optional<Despesa> optionalDespesa = despesaRepository.findById(id);
		if(optionalDespesa.isPresent()) {
			return optionalDespesa.get();
		}
		throw new Exception("Não foi encontrado uma conta com o id " + id);
	}
	
	public Integer deletar(Integer id) {
		despesaRepository.deleteById(id);
		return id;
	}
}
