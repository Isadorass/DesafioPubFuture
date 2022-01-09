package br.com.isadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isadora.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}