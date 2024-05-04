package com.syrine.instruments;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.entities.Role;
import com.syrine.instruments.entities.User;
import com.syrine.instruments.service.InstrumentService;
import com.syrine.instruments.service.UserService;

import jakarta.annotation.PostConstruct;

import org.thymeleaf.templatemode.TemplateMode;


@SpringBootApplication
public class InstrumentProjectApplication  implements CommandLineRunner{
	@Autowired 
	InstrumentService instrumentService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(InstrumentProjectApplication.class, args);
	}
	
	/*
	 * @PostConstruct void init_users() { //ajouter les rôles
	 * userService.addRole(new Role(null,"ADMIN")); userService.addRole(new
	 * Role(null,"AGENT")); userService.addRole(new Role(null,"USER")); //ajouter
	 * les users userService.saveUser(new User(null,"admin","123",true,null));
	 * userService.saveUser(new User(null,"syrine","123",true,null));
	 * userService.saveUser(new User(null,"user1","123",true,null)); //ajouter les
	 * rôles aux users userService.addRoleToUser("admin", "ADMIN");
	 * userService.addRoleToUser("syrine", "USER");
	 * userService.addRoleToUser("syrine", "AGENT");
	 * userService.addRoleToUser("user1", "USER"); }
	 */
	
	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println("Password Encoded BCRYPT :******************** ");
		// System.out.println(passwordEncoder.encode("123"));
	/*produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
	produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
	produitService.saveProduit(new Produit("Imp Epson", 900.0, new Date()));
	*/
		
	}


}
