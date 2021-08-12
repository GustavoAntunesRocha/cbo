package br.com.gustavo.cbo.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.cbo.model.Ocupacao;
import br.com.gustavo.cbo.repository.OcupacaoRepository;

@Service
public class Arquivo {

	@Autowired
	private OcupacaoRepository repository;
	
	// TODO avaliar momento
	public void carrega(String path) {
		BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ";";
	    try {

	        br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
	        while ((linha = br.readLine()) != null) {

	        	linha = removeSinais(linha);
	            String[] aux = linha.split(csvDivisor);
	            Ocupacao ocupacao = new Ocupacao(aux[0], aux[1]);
	            repository.save(ocupacao);

	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	private static String removeSinais(String entrada) {
        String sa = Normalizer.normalize(entrada, Normalizer.Form.NFD);

        return sa.replaceAll("\\p{M}", "");
    }
}
