package br.com.gustavo.cbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavo.cbo.model.Ocupacao;

@Repository
public interface OcupacaoRepository extends JpaRepository<Ocupacao, Integer>{

}
