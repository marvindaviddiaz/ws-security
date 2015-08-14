package com.bytesw.hubpagos.ws.soap.server.endpoint.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapMessage;

public class SoapActionRequiredEndpointInterceptor implements EndpointInterceptor{
	
	private List<String> validSoapActions = new ArrayList<>();

	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
		WebServiceMessage request = messageContext.getRequest();
		 if (request instanceof SoapMessage) {
	            String soapAction = ((SoapMessage) request).getSoapAction();
	            if (StringUtils.hasLength(soapAction) && soapAction.charAt(0) == '"' &&
	                    soapAction.charAt(soapAction.length() - 1) == '"') {
	                soapAction = soapAction.substring(1, soapAction.length() - 1);
	            }
	            if(!validSoapActions.contains(soapAction)){
	            	throw new InvalidSoapActionException("Invalid SoapAction: " + soapAction);
	            }else{
	            	return true;
	            }
		 } else {
			 return false;
	     }
	}

	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void setValidSoapActions(List<String> validSoapActions) {
		this.validSoapActions = validSoapActions;
	}
	
}
