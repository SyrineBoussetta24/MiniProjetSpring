package com.syrine.instruments;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import com.syrine.instruments.entities.Instrument;

import com.syrine.instruments.service.InstrumentService;

import org.thymeleaf.templatemode.TemplateMode;


@SpringBootApplication
public class InstrumentProjectApplication  implements CommandLineRunner{
	@Autowired 
	InstrumentService instrumentService;

	public static void main(String[] args) {
		SpringApplication.run(InstrumentProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	/*produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
	produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
	produitService.saveProduit(new Produit("Imp Epson", 900.0, new Date()));
	*/
		
	}


}
