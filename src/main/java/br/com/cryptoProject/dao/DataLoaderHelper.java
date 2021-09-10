package br.com.cryptoProject.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.cryptoProject.model.CriptoMoeda;
import br.com.cryptoProject.model.User;


@Service
public class DataLoaderHelper {
	
	public static void loadData(
		CriptoMoedaRepository daoCripto,	
		UserRepository daoUser) {
		
		
		
		
		CriptoMoeda cripto1 = new CriptoMoeda();
		cripto1.setCodigo("0-5x-long-ethereum-classic-token");
		cripto1.setNome("teste ETH");
		cripto1.setUrl_projeto("www.url.com");
		daoCripto.save(cripto1);
/* Exemplo para salvar o usuario com senha criptografada */
	BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();

	User admin = new User();
	admin.setEmail("admin@test.org");
	admin.setPassword(passEncoder.encode("123"));
	admin.setConfirmPassword(passEncoder.encode("123"));
	admin.setNome("admin");
	daoUser.save(admin);

	}
	@Bean
	public CommandLineRunner loader(CriptoMoedaRepository daoCripto, UserRepository daoUser) {
		return (args) -> {
			DataLoaderHelper.loadData(daoCripto, daoUser);
			};
		}
}

