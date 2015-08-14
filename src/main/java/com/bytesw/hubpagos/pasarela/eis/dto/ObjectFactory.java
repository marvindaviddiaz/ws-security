
package com.bytesw.hubpagos.pasarela.eis.dto;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bytesw.hubpagos.pasarela.eis.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bytesw.hubpagos.pasarela.eis.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PayBillResponse }
     * 
     */
    public PayBillResponse createPayBillResponse() {
        return new PayBillResponse();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link CamposCobranza }
     * 
     */
    public CamposCobranza createCamposCobranza() {
        return new CamposCobranza();
    }

    /**
     * Create an instance of {@link GetBalanceRequest }
     * 
     */
    public GetBalanceRequest createGetBalanceRequest() {
        return new GetBalanceRequest();
    }

    /**
     * Create an instance of {@link GetBillersRequest }
     * 
     */
    public GetBillersRequest createGetBillersRequest() {
        return new GetBillersRequest();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link PayBillRequest }
     * 
     */
    public PayBillRequest createPayBillRequest() {
        return new PayBillRequest();
    }

    /**
     * Create an instance of {@link GetBillersResponse }
     * 
     */
    public GetBillersResponse createGetBillersResponse() {
        return new GetBillersResponse();
    }

    /**
     * Create an instance of {@link Cobranza }
     * 
     */
    public Cobranza createCobranza() {
        return new Cobranza();
    }

    /**
     * Create an instance of {@link GetSessionRequest }
     * 
     */
    public GetSessionRequest createGetSessionRequest() {
        return new GetSessionRequest();
    }

    /**
     * Create an instance of {@link GetSessionResponse }
     * 
     */
    public GetSessionResponse createGetSessionResponse() {
        return new GetSessionResponse();
    }

}
