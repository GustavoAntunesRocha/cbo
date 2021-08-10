package br.com.gustavo.cbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.gustavo.cbo.service.Arquivo;

@SpringBootApplication
@Component
public class CboApplication {

	public static final String IN_DIR = "./src/main/resources/planilhasEntrada/CBO2002-Ocupacao.csv";    
    
    @Autowired
    private Arquivo arquivo;
    
    
	public static void main(String[] args) {
		SpringApplication.run(CboApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	private void processa() {
		arquivo.carrega(IN_DIR);
	}

}
