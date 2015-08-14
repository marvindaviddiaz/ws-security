package com.bytesw.hubpagos.pasarela;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.security.auth.callback.CallbackHandler;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.security.support.KeyStoreFactoryBean;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.KeyStoreCallbackHandler;
import org.springframework.ws.soap.security.xwss.callback.SimpleUsernamePasswordCallbackHandler;

import com.bytesw.hubpagos.backend.eis.dto.ChargeAccountRequest;
import com.bytesw.hubpagos.backend.eis.dto.ChargeAccountResponse;
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

public class BackEndTest {

	private SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
	private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	private KeyStoreFactoryBean keyStoreJKS = new KeyStoreFactoryBean();
	private KeyStoreCallbackHandler keyStoreForEncryptAndSign = new KeyStoreCallbackHandler();
	private SimpleUsernamePasswordCallbackHandler usernameToken = new SimpleUsernamePasswordCallbackHandler();
	private WebServiceTemplate template = new WebServiceTemplate();

	@Before
	public void before() {
		try {

			messageFactory.setSoapVersion(SoapVersion.SOAP_11);
			messageFactory.afterPropertiesSet();

			marshaller.setPackagesToScan(new String[] { "com.bytesw.hubpagos.backend.eis.dto" });
			marshaller.afterPropertiesSet();

			keyStoreJKS.setLocation(new ClassPathResource("keystore/client1ks.jks"));
			keyStoreJKS.setPassword("test1234");
			keyStoreJKS.afterPropertiesSet();

			/** USERNAME TOKEN */
			usernameToken.setUsername("mdiaz");
			usernameToken.setPassword("d033e22ae348aeb5660fc2140aec35850c4da997");
			usernameToken.afterPropertiesSet();

			/** ENCRIPT & SIGN */
			// For encryption we will use server's public key
			// Password is empty since public key is not securement with another
			// password
			keyStoreForEncryptAndSign.setTrustStore(keyStoreJKS.getObject());
			// For sign we will use client's private key
			// Password must be client's privateKey
			keyStoreForEncryptAndSign.setKeyStore(keyStoreJKS.getObject());
			keyStoreForEncryptAndSign.setPrivateKeyPassword("client1pass");
			keyStoreForEncryptAndSign.setDefaultAlias("client1");
			// Este mismo callback sirve para todas las operaciones de cifrado
			keyStoreForEncryptAndSign.afterPropertiesSet();

			template.setMessageFactory(messageFactory);
			template.setMarshaller(marshaller);
			template.setUnmarshaller(marshaller);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test() {
		try {
			String sessionId = this.getSession();
			this.validateSession(sessionId);
			this.userAccounts(sessionId);
			this.secondAuthentication(sessionId);
			this.chargeAccount(sessionId);
			this.reverseCharge(sessionId);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public String getSession() throws Exception {

		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientLoginPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { usernameToken, keyStoreForEncryptAndSign });
		i.afterPropertiesSet();

		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();

		/*
		 * La presencia y el contenido del campo de encabezado SOAPAction puede
		 * ser utilizado por los servidores, como los servidores de seguridad
		 * para filtrar adecuadamente los mensajes de solicitud SOAP en HTTP. El
		 * valor del campo de encabezado de cadena vacía ("") significa que la
		 * intención del mensaje SOAP es proporcionada por el HTTP Request-URI.
		 * No valor significa que no hay ninguna indicación de la intención del
		 * mensaje.
		 */
		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://backend.hubpagos.bytesw.com/GetSession");

		GetSessionRequest req = new GetSessionRequest();
		GetSessionResponse resp = (GetSessionResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/BackEndWS", req, callbackForSoapAction);

		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
		return resp.getSesionId();
	}

	public void validateSession(String sessionId) throws Exception {

		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();

		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();

		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://backend.hubpagos.bytesw.com/ValidateSession");
		ValidateSessionRequest req = new ValidateSessionRequest();
		req.setSesionId(sessionId);
		ValidateSessionResponse resp = (ValidateSessionResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/BackEndWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}

	public void userAccounts(String sessionId) throws Exception {

		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();

		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();

		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://backend.hubpagos.bytesw.com/UserAccounts");
		UserAccountsRequest req = new UserAccountsRequest();
		req.setSesionId(sessionId);
		req.setUserAlias("mdiaz");
		UserAccountsResponse resp = (UserAccountsResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/BackEndWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}

	public void secondAuthentication(String sessionId) throws Exception {

		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();

		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();

		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://backend.hubpagos.bytesw.com/SecondAuthentication");
		SecondAuthenticationRequest req = new SecondAuthenticationRequest();
		req.setSesionId(sessionId);
		req.setUserAlias("mdiaz");
		req.setValor1("A1194083");
		
		SecondAuthenticationResponse resp = (SecondAuthenticationResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/BackEndWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	public void chargeAccount(String sessionId) throws Exception {
		
		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();
		
		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();
		
		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://backend.hubpagos.bytesw.com/ChargeAccount");
		ChargeAccountRequest req = new ChargeAccountRequest();
		req.setSesionId(sessionId);
		req.setUserAlias("mdiaz");
		req.setNumeroCuenta(new BigInteger("458761"));
		req.setProducto(6);
		req.setMoneda("GTQ");
		req.setFechaVencimientoTC(122016);
		req.setCvv2(456);
		req.setMontoSinImpuesto(BigDecimal.TEN);
		req.setImpuesto(BigDecimal.TEN);
		req.setTotalDebitar(BigDecimal.TEN);
		req.setCobranza(444);
		req.setNombreCobranza("Colegio Parvulitos");
		req.setIdPago("99999");
		
		ChargeAccountResponse resp = (ChargeAccountResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/BackEndWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	public void reverseCharge(String sessionId) throws Exception {
		
		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();
		
		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();
		
		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://backend.hubpagos.bytesw.com/ReverseCharge");
		ReverseChargeRequest req = new ReverseChargeRequest();
		req.setSesionId(sessionId);
		req.setUserAlias("mdiaz");
		req.setAutorizacionDebito(789456);
		req.setMotivo("Error cuenta incorrecta");
		
		ReverseChargeResponse resp = (ReverseChargeResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/BackEndWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}

}
