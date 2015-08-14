package com.bytesw.hubpagos.pasarela.view.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.bytesw.hubpagos.pasarela.eis.dto.CamposCobranza;
import com.bytesw.hubpagos.pasarela.eis.dto.Cobranza;
import com.bytesw.hubpagos.pasarela.eis.dto.Error;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBalanceRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBalanceResponse;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBillersRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBillersResponse;
import com.bytesw.hubpagos.pasarela.eis.dto.GetSessionRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.GetSessionResponse;
import com.bytesw.hubpagos.pasarela.eis.dto.PayBillRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.PayBillResponse;

@Endpoint
public class PasarelaEndpoint {

	private static final String NAMESPACE_URI = "http://dto.eis.pasarela.hubpagos.bytesw.com/";
	private static final String NAMESPACE_SOAP_ACTION = "http://pasarela.hubpagos.bytesw.com/";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetSessionRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "GetSession")
	public @ResponsePayload GetSessionResponse getSession(@RequestPayload GetSessionRequest request) throws Exception {

		GetSessionResponse resp = new GetSessionResponse();
		resp.setSesionId(TOKEN);
		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBillersRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "GetBillers")
	public @ResponsePayload GetBillersResponse getBillers(@RequestPayload GetBillersRequest request) throws Exception {

		GetBillersResponse resp = new GetBillersResponse();
		
		if (TOKEN.equals(request.getSesionId())) {
			Cobranza c = new Cobranza();
			c.setCodigo(1);
			c.setNombre("Cobranza Uno");
			resp.getCobranzas().add(c);
		}else{
			resp.setError(new Error());
			resp.getError().setCodigo(999);
			resp.getError().setDescripcion("Sesion Invalida");
		}

		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBalanceRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "GetBalance")
	public @ResponsePayload GetBalanceResponse getBalance(@RequestPayload GetBalanceRequest request) throws Exception {

		GetBalanceResponse resp = new GetBalanceResponse();
		
		if (TOKEN.equals(request.getSesionId())) {
			CamposCobranza c = new CamposCobranza();
			c.setCampo1("0900-10-4557");
			c.setCampo2("2015-7-1");
			c.setCampo3("885.00");
			c.setCampo4("Pago Inscripcion");
			resp.setCamposCobranza(c);
		}else{
			resp.setError(new Error());
			resp.getError().setCodigo(999);
			resp.getError().setDescripcion("Sesion Invalida");
		}

		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PayBillRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "PayBill")
	public @ResponsePayload PayBillResponse payBill(@RequestPayload PayBillRequest request) throws Exception {

		PayBillResponse resp = new PayBillResponse();
		
		if (TOKEN.equals(request.getSesionId())) {
			CamposCobranza c = new CamposCobranza();
			c.setCampo1("0900-10-4557");
			c.setCampo2("2015-7-1");
			c.setCampo3("885.00");
			c.setCampo4("Pago Inscripcion");
			resp.setCamposCobranza(c);
			resp.setAutorizacionFacturador("0000000000000099");
		}else{
			resp.setError(new Error());
			resp.getError().setCodigo(999);
			resp.getError().setDescripcion("Sesion Invalida");
		}

		return resp;
	}
	
	
	private String TOKEN = "554/q*-a4df^#(@7245-2rs*/df";
	
}