package br.com.gustavo.cbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavo.cbo.model.Ocupacao;
import br.com.gustavo.cbo.service.OcupacaoService;

@RestController
@RequestMapping("/cbo")
public class OcupacaoController {

	@Autowired
	private OcupacaoService service;
	
	@GetMapping("/titulo/{titulo}")
	public String getOcupacaoTitulo(@PathVariable String titulo) {
		List<Ocupacao> ocupacao = service.buscaTitulo(titulo);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(ocupacao);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/codigo/{codigo}")
	public String getOcupacaoCodigo(@PathVariable String codigo) {
		Ocupacao ocupacao = service.buscaCodigo(codigo);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(ocupacao);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
