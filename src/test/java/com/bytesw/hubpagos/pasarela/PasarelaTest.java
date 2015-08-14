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

import com.bytesw.hubpagos.pasarela.eis.dto.CamposCobranza;
import com.bytesw.hubpagos.pasarela.eis.dto.Canal;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBalanceRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBalanceResponse;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBillersRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.GetBillersResponse;
import com.bytesw.hubpagos.pasarela.eis.dto.GetSessionRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.GetSessionResponse;
import com.bytesw.hubpagos.pasarela.eis.dto.PayBillRequest;
import com.bytesw.hubpagos.pasarela.eis.dto.PayBillResponse;

public class PasarelaTest {

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

			marshaller.setPackagesToScan(new String[] { "com.bytesw.hubpagos.pasarela.eis.dto" });
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
			this.getBillers(sessionId);
			this.getBalance(sessionId);
			this.payBill(sessionId);
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
		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://pasarela.hubpagos.bytesw.com/GetSession");

		GetSessionRequest req = new GetSessionRequest();
		req.setCanal(Canal.IB);
		GetSessionResponse resp = (GetSessionResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/PasarelaWS", req, callbackForSoapAction);

		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
		return resp.getSesionId();
	}

	public void getBillers(String sessionId) throws Exception {

		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();

		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();

		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://pasarela.hubpagos.bytesw.com/GetBillers");
		GetBillersRequest req = new GetBillersRequest();
		req.setSesionId(sessionId);
		GetBillersResponse resp = (GetBillersResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/PasarelaWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}

	public void getBalance(String sessionId) throws Exception {

		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();

		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();

		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://pasarela.hubpagos.bytesw.com/GetBalance");
		GetBalanceRequest req = new GetBalanceRequest();
		req.setSesionId(sessionId);
		req.setIdConsulta("12345");
		req.setCamposCobranza(new CamposCobranza());
		req.getCamposCobranza().setCampo1("Alfredo Avila");
		req.getCamposCobranza().setCampo2("0900-10-4557");
		GetBalanceResponse resp = (GetBalanceResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/PasarelaWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}

	public void payBill(String sessionId) throws Exception {

		XwsSecurityInterceptor i = new XwsSecurityInterceptor();
		i.setPolicyConfiguration(new ClassPathResource("clientSecurityPolicy.xml"));
		i.setCallbackHandlers(new CallbackHandler[] { keyStoreForEncryptAndSign });
		i.afterPropertiesSet();

		template.setInterceptors(new ClientInterceptor[] { i });
		template.afterPropertiesSet();

		ClientMessageCallBack callbackForSoapAction = new ClientMessageCallBack("http://pasarela.hubpagos.bytesw.com/PayBill");
		PayBillRequest req = new PayBillRequest();
		req.setSesionId(sessionId);
		req.setCamposCobranza(new CamposCobranza());
		req.setNumeroCuenta(new BigInteger("01510139976"));
		req.setIdPago("12345");
		req.setMoneda("QTZ");
		req.setSubTotal(BigDecimal.TEN);
		req.setImpuestos(BigDecimal.TEN);
		req.setTotal(BigDecimal.TEN);
		
		PayBillResponse resp = (PayBillResponse) template.marshalSendAndReceive("http://localhost:8080/servicios-hub/services/PasarelaWS", req, callbackForSoapAction);
		System.out.println("#### RESPUESTA: " + ReflectionToStringBuilder.reflectionToString(resp, ToStringStyle.MULTI_LINE_STYLE));
	}

}
