package br.com.isadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>Classe responsável por rodar a aplicação.</h1>
 * 
 * <p>Classe responsável por
 * conter o método principal do projeto
 * que inicia a aplicação SpringBoot.</p>
 * 
 * @author Isadora de Souza e Silva <strong>isadorass1710@gmail.com</strong>
 */
@SpringBootApplication
public class RunApp {
	public static void main(String[] args) {
		SpringApplication.run(RunApp.class, args);
	}
}