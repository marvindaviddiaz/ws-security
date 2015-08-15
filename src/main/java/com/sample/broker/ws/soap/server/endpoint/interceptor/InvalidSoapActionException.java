package com.sample.broker.ws.soap.server.endpoint.interceptor;

public class InvalidSoapActionException extends Exception {

	private static final long serialVersionUID = -5921222959962196321L;

	public InvalidSoapActionException(String message) {
		super(message);
	}
}
