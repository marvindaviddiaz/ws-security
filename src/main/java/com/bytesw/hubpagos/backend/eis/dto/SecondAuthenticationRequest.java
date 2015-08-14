
package com.bytesw.hubpagos.backend.eis.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sesionId" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredForty"/>
 *         &lt;element name="userAlias" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredForty"/>
 *         &lt;element name="valor1" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredTwentyFive"/>
 *         &lt;element name="valor2" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringTwentyFive"/>
 *         &lt;element name="valor3" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringTwentyFive"/>
 *         &lt;element name="valor4" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringTwentyFive"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sesionId",
    "userAlias",
    "valor1",
    "valor2",
    "valor3",
    "valor4"
})
@XmlRootElement(name = "SecondAuthenticationRequest")
public class SecondAuthenticationRequest {

    @XmlElement(required = true)
    protected String sesionId;
    @XmlElement(required = true)
    protected String userAlias;
    @XmlElement(required = true)
    protected String valor1;
    @XmlElement(required = true, nillable = true)
    protected String valor2;
    @XmlElement(required = true, nillable = true)
    protected String valor3;
    @XmlElement(required = true, nillable = true)
    protected String valor4;

    /**
     * Obtiene el valor de la propiedad sesionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesionId() {
        return sesionId;
    }

    /**
     * Define el valor de la propiedad sesionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesionId(String value) {
        this.sesionId = value;
    }

    /**
     * Obtiene el valor de la propiedad userAlias.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserAlias() {
        return userAlias;
    }

    /**
     * Define el valor de la propiedad userAlias.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserAlias(String value) {
        this.userAlias = value;
    }

    /**
     * Obtiene el valor de la propiedad valor1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor1() {
        return valor1;
    }

    /**
     * Define el valor de la propiedad valor1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor1(String value) {
        this.valor1 = value;
    }

    /**
     * Obtiene el valor de la propiedad valor2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor2() {
        return valor2;
    }

    /**
     * Define el valor de la propiedad valor2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor2(String value) {
        this.valor2 = value;
    }

    /**
     * Obtiene el valor de la propiedad valor3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor3() {
        return valor3;
    }

    /**
     * Define el valor de la propiedad valor3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor3(String value) {
        this.valor3 = value;
    }

    /**
     * Obtiene el valor de la propiedad valor4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor4() {
        return valor4;
    }

    /**
     * Define el valor de la propiedad valor4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor4(String value) {
        this.valor4 = value;
    }

}
