package com.pravada.retailapp.myRetail.redskyClient;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.pravada.retailapp.myRetail.dto.RedskyClientProductResponseDTO;

@Component
public class RedskyClient {
	
	public static Logger logger = LogManager.getLogger(RedskyClient.class);


	@Autowired
	private Environment env;

	public RedskyClientProductResponseDTO getProductInfo(int productId) {
		RedskyClientProductResponseDTO response = null;
		RestTemplate restTemplate = new RestTemplate();
		URI uri;
		try {
			uri = new URI(env.getProperty("redsky.client.url").concat((String.valueOf(productId))));
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			logger.info("RESPONSE IS ... " + result);

			//convert response to json object
			Gson g = new Gson();  
			response = g.fromJson(result.getBody(), RedskyClientProductResponseDTO.class) ; 
		} catch (final HttpStatusCodeException e) {
			throw new RestClientException(e.getRawStatusCode() + " " + e.getResponseBodyAsString());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			logger.warn(e1.getStackTrace());
		}

		return response;

	}

}
