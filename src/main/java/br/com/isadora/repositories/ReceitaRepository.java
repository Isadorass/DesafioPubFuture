package br.com.isadora.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isadora.entities.Receita;
import br.com.isadora.enums.TipoReceita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
	
	List<Receita> findByTipoReceita(TipoReceita tipoReceita);

	List<Receita> findByDataRecebimentoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);

	List<Receita> findByDataRecebimentoEsperadoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
}