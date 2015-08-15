
package com.sample.broker.eis.dto;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sample.broker.eis.dto package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sample.broker.eis.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountriesRequest }
     * 
     */
    public GetCountriesRequest createGetCountriesRequest() {
        return new GetCountriesRequest();
    }

    /**
     * Create an instance of {@link GetCountriesResponse }
     * 
     */
    public GetCountriesResponse createGetCountriesResponse() {
        return new GetCountriesResponse();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
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
