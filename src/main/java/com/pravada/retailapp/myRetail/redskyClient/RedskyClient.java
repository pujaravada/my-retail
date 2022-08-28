package com.pravada.retailapp.myRetail.redskyClient;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.pravada.retailapp.myRetail.dto.RedskyClientProductResponseDTO;

@Component
public class RedskyClient {

//	@Autowired
//	private RestTemplate restTemplate;

	// TODO - Add retry
	//tracing
	//Add post call
	public RedskyClientProductResponseDTO getProductInfo(int productId) {
		RedskyClientProductResponseDTO response = null;
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/case_study_v1?key=3yUxt7WltYG7MFKPp7uyELi1K40ad2ys&tcin=13860428";
		URI uri;
		try {
			uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			System.out.println("RESPONSE IS ... " + result);
			
			//convert response to json object
			
			
			Gson g = new Gson();  
			response = g.fromJson(result.getBody(), RedskyClientProductResponseDTO.class) ; 

		} catch (final HttpStatusCodeException e) {
			throw new RestClientException(e.getRawStatusCode() + " " + e.getResponseBodyAsString());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return response;

	}

}
