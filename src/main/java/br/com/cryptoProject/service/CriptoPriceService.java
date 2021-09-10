package br.com.cryptoProject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cryptoProject.Commons.Price;

@Service
public class CriptoPriceService {
	

    @Autowired
    private RestTemplate apiRequest;
    
public ResponseEntity<Map<String, Price>> getCriptoPriceById(String id) {
    	
	//Price classprice = new Price();
	
//		Map<String, String> params = new HashMap<>();
//					//01 coin + ""
//		params.put(id, "");
//		params.put("usd", "");
		
    	String url = 
        		"https://api.coingecko.com/api/v3/simple/price?ids="+id+"&vs_currencies=usd" ;
    	 	    	
    	//Teste price = apiRequest.getForObject(url, Teste.class, params);
    	
    	ParameterizedTypeReference<Map<String, Price>> ptr = 
    			new ParameterizedTypeReference<Map<String, Price>>(){};

        ResponseEntity<Map<String, Price>> re = apiRequest.exchange(url, HttpMethod.GET, null, ptr);
//    	TypeFactory typeFactory = mapper.getTypeFactory();
//    	MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Price.class);
//    	HashMap<String, Price> map = mapper.readValue(json, mapType);
        
        return re; // serializado em JSON
        
    }


}
