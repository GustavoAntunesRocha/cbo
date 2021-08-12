package br.com.gustavo.cbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.cbo.model.Ocupacao;
import br.com.gustavo.cbo.repository.OcupacaoRepository;

@Service
public class OcupacaoService {

	@Autowired
	private OcupacaoRepository repository;
	
	public Ocupacao buscaCodigo(int codigo) {
		return repository.findByCodigo(codigo);
	}
	
	public List<Ocupacao> buscaTitulo(String titulo){
		return repository.findByTituloContainingIgnoreCase(titulo);
	}
}
