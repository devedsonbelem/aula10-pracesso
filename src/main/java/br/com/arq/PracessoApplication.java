package br.com.arq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.arq.service.UsersService;

@SpringBootApplication
@EnableMongoRepositories
public class PracessoApplication implements CommandLineRunner {

	@Autowired 
	private UsersService service;
	
 
	public static void main(String[] args) {
		SpringApplication.run(PracessoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//	String senha="senhasecretae_segura123456";
//		 
//	 String resposta = 	service.encrypt(senha);
//		System.out.println("cripto :" + resposta);
//		
//		
//		
//		Boolean  volta = service.decrypt(resposta);
// 
//		System.out.println("Somente Data :" + volta);
//		
		
	}
	
	/*
	 * https://olastrings.com/string-builder
	 * 
	 */

}
