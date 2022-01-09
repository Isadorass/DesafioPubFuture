package br.com.isadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isadora.entities.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

}
