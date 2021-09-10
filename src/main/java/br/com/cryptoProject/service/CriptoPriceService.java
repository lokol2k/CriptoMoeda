package br.com.cryptoProject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cryptoProject.commons.Price;

@Service
public class CriptoPriceService {
	

    @Autowired
    private RestTemplate apiRequest;
    
public ResponseEntity<Map<String, Price>> getCriptoPriceById(String id) {
    	
    	String url = 
        		"https://api.coingecko.com/api/v3/simple/price?ids="+id+"&vs_currencies=usd" ;
    	
    	ParameterizedTypeReference<Map<String, Price>> ptr = 
    			new ParameterizedTypeReference<Map<String, Price>>(){};

        ResponseEntity<Map<String, Price>> result = apiRequest.exchange(url, HttpMethod.GET, null, ptr);
        
        return result;
        
    }


}
