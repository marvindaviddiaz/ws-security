package com.bytesw.hubpagos.backend.view.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.bytesw.hubpagos.backend.eis.dto.ChargeAccountRequest;
import com.bytesw.hubpagos.backend.eis.dto.ChargeAccountResponse;
import com.bytesw.hubpagos.backend.eis.dto.Error;
import com.bytesw.hubpagos.backend.eis.dto.GetSessionRequest;
import com.bytesw.hubpagos.backend.eis.dto.GetSessionResponse;
import com.bytesw.hubpagos.backend.eis.dto.ReverseChargeRequest;
import com.bytesw.hubpagos.backend.eis.dto.ReverseChargeResponse;
import com.bytesw.hubpagos.backend.eis.dto.SecondAuthenticationRequest;
import com.bytesw.hubpagos.backend.eis.dto.SecondAuthenticationResponse;
import com.bytesw.hubpagos.backend.eis.dto.UserAccountsRequest;
import com.bytesw.hubpagos.backend.eis.dto.UserAccountsResponse;
import com.bytesw.hubpagos.backend.eis.dto.ValidateSessionRequest;
import com.bytesw.hubpagos.backend.eis.dto.ValidateSessionResponse;

@Endpoint
public class BackEndEndpoint {

	private static final String NAMESPACE_URI = "http://dto.eis.backend.hubpagos.bytesw.com/";
	private static final String NAMESPACE_SOAP_ACTION = "http://backend.hubpagos.bytesw.com/";
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetSessionRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "GetSession")
	public @ResponsePayload GetSessionResponse getSession(@RequestPayload GetSessionRequest request) throws Exception {

		GetSessionResponse resp = new GetSessionResponse();
		resp.setSesionId(TOKEN);
		return resp;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ValidateSessionRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "ValidateSession")
	public @ResponsePayload ValidateSessionResponse validateSession(@RequestPayload ValidateSessionRequest request) throws Exception {

		ValidateSessionResponse resp = new ValidateSessionResponse();
		resp.setUserAlias("123456");
		resp.setError(new com.bytesw.hubpagos.backend.eis.dto.Error());
		resp.getError().setCodigo(456);
		resp.getError().setDescripcion("adf");

		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserAccountsRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "UserAccounts")
	public @ResponsePayload UserAccountsResponse userAccounts(@RequestPayload UserAccountsRequest request) throws Exception {

		UserAccountsResponse resp = new UserAccountsResponse();
		resp.setError(new Error());
		resp.getError().setCodigo(456);
		resp.getError().setDescripcion("adf");

		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SecondAuthenticationRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "SecondAuthentication")
	public @ResponsePayload SecondAuthenticationResponse secondAuthentication(@RequestPayload SecondAuthenticationRequest request) throws Exception {

		SecondAuthenticationResponse resp = new SecondAuthenticationResponse();
		resp.setError(new Error());
		resp.getError().setCodigo(456);
		resp.getError().setDescripcion("adf");

		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ChargeAccountRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "ChargeAccount")
	public @ResponsePayload ChargeAccountResponse chargeAccount(@RequestPayload ChargeAccountRequest request) throws Exception {

		ChargeAccountResponse resp = new ChargeAccountResponse();
		resp.setError(new Error());
		resp.getError().setCodigo(456);
		resp.getError().setDescripcion("adf");

		return resp;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReverseChargeRequest")
	@SoapAction(NAMESPACE_SOAP_ACTION + "ReverseCharge")
	public @ResponsePayload ReverseChargeResponse reverseCharge(@RequestPayload ReverseChargeRequest request) throws Exception {

		ReverseChargeResponse resp = new ReverseChargeResponse();
		resp.setError(new Error());
		resp.getError().setCodigo(456);
		resp.getError().setDescripcion("adf");

		return resp;
	}
	
	private String TOKEN = "554/q*-a4df^#(@7245-2rs*/df";
}