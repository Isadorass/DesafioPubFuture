package br.com.isadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isadora.entities.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}
