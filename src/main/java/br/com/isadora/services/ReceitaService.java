package br.com.isadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isadora.entities.Receita;
import br.com.isadora.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository; 
	
	public Integer criar(Receita receita){
		return receitaRepository.save(receita).getId();
	}
	
	public Integer atualizar(Receita receita) {
		return receitaRepository.save(receita).getId();
	}
	
	public Receita buscarPorId(Integer id) throws Exception {
		Optional<Receita> optionalReceita = receitaRepository.findById(id);
		if(optionalReceita.isPresent()) {
			return optionalReceita.get();
		}
		throw new Exception("Não foi encontrado uma conta com o id " + id);
	}
	
	public Integer deletar(Integer id) {
		receitaRepository.deleteById(id);
		return id;
	}
}
