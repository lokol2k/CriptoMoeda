package br.com.cryptoProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cryptoProject.Commons.WrapperCoins;
import br.com.cryptoProject.model.CriptoMoedaCoingecko;

@Service
public class CriptoMoedaCoingeckoService {
	@Configuration
	public class RestTemplateClient {
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	}

    @Autowired
    private RestTemplate apiRequest;
    
public CriptoMoedaCoingecko getCriptoById(String id) {
    	
    	String url = 
        		"https://api.coingecko.com/api/v3/coins/" + id;
    	try {
    	CriptoMoedaCoingecko cripto = apiRequest.getForObject(url, CriptoMoedaCoingecko.class);
    		return cripto;
    	}catch (Exception handlerException) {
    		
    		return null;
    	}
    	
        // serializado em JSON
        
    }


public WrapperCoins getCriptosId() {
	
	
	
	String url = 
    		"https://api.coingecko.com/api/v3/coins/list";
	
	
	WrapperCoins  ids = apiRequest.getForObject(url, WrapperCoins.class);
	
	return ids;
	
	
	
}

}
