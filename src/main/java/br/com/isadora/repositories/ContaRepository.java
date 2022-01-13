package br.com.isadora.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isadora.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
	List<Conta> findByInstituicaoFinanceira(String instituicaoFinanceira);
}