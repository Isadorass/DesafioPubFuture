package br.com.isadora.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isadora.entities.Despesa;
import br.com.isadora.enums.TipoDespesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {
	List<Despesa> findByTipoDespesa(TipoDespesa tipoDespesa);

	List<Despesa> findByDataPagamentoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);

	List<Despesa> findByDataPagamentoEsperadoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
}