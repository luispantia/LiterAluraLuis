package com.Luis.catalogolibros;

import com.Luis.catalogolibros.principal.Principal;
import com.Luis.catalogolibros.repository.AutoresRepository;
import com.Luis.catalogolibros.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CatalogolibrosApplication implements CommandLineRunner {

	@Autowired
	private LibrosRepository librosRepository;
	@Autowired
	private AutoresRepository autoresRepository;


	public static void main(String[] args) {
		SpringApplication.run(CatalogolibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(librosRepository, autoresRepository);

			principal.miMenu();
	}
}
