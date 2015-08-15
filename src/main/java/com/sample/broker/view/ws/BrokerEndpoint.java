package com.sample.broker.view.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.sample.broker.eis.dto.Country;
import com.sample.broker.eis.dto.Error;
import com.sample.broker.eis.dto.GetCountriesRequest;
import com.sample.broker.eis.dto.GetCountriesResponse;
import com.sample.broker.eis.dto.GetSessionRequest;
import com.sample.broker.eis.dto.GetSessionResponse;

@Endpoint
public class BrokerEndpoint {

	private static final String NAMESPACE_URI = "http://dto.eis.broker.sample.com/";
	private static final String NAMESPACE_SOAP_ACTION = "http://broker.sample.com/";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetSessionRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "GetSession")
	public @ResponsePayload GetSessionResponse getSession(@RequestPayload GetSessionRequest request) throws Exception {

		GetSessionResponse resp = new GetSessionResponse();
		resp.setSesionId(TOKEN);
		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCountriesRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "GetCountries")
	public @ResponsePayload GetCountriesResponse getBillers(@RequestPayload GetCountriesRequest request) throws Exception {

		GetCountriesResponse resp = new GetCountriesResponse();
		
		if (TOKEN.equals(request.getSesionId())) {
			Country c= new Country();
			c.setCodigo("GT");
			c.setNombre("Guatemala");
			c.setMoneda("GTQ");
			resp.getCountries().add(c);

			Country c2= new Country();
			c2.setCodigo("US");
			c2.setNombre("Estados Unidos");
			c2.setMoneda("USD");
			resp.getCountries().add(c2);
			
		}else{
			resp.setError(new Error());
			resp.getError().setCodigo(999);
			resp.getError().setDescripcion("Sesion Invalida");
		}

		return resp;
	}
	
	private String TOKEN = "554/q*-a4df^#(@7245-2rs*/df";
	
}