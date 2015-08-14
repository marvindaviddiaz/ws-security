
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
 *         &lt;element name="error" type="{http://dto.eis.backend.hubpagos.bytesw.com/}error"/>
 *         &lt;element name="userAlias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="metodoAutenticacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cordenada1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cordenada2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cordenada3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cordenada4" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "error",
    "userAlias",
    "metodoAutenticacion",
    "cordenada1",
    "cordenada2",
    "cordenada3",
    "cordenada4"
})
@XmlRootElement(name = "ValidateSessionResponse")
public class ValidateSessionResponse {

    @XmlElement(required = true, nillable = true)
    protected Error error;
    @XmlElement(required = true, nillable = true)
    protected String userAlias;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer metodoAutenticacion;
    @XmlElement(required = true, nillable = true)
    protected String cordenada1;
    @XmlElement(required = true, nillable = true)
    protected String cordenada2;
    @XmlElement(required = true, nillable = true)
    protected String cordenada3;
    @XmlElement(required = true, nillable = true)
    protected String cordenada4;

    /**
     * Obtiene el valor de la propiedad error.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getError() {
        return error;
    }

    /**
     * Define el valor de la propiedad error.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setError(Error value) {
        this.error = value;
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
     * Obtiene el valor de la propiedad metodoAutenticacion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMetodoAutenticacion() {
        return metodoAutenticacion;
    }

    /**
     * Define el valor de la propiedad metodoAutenticacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMetodoAutenticacion(Integer value) {
        this.metodoAutenticacion = value;
    }

    /**
     * Obtiene el valor de la propiedad cordenada1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCordenada1() {
        return cordenada1;
    }

    /**
     * Define el valor de la propiedad cordenada1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCordenada1(String value) {
        this.cordenada1 = value;
    }

    /**
     * Obtiene el valor de la propiedad cordenada2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCordenada2() {
        return cordenada2;
    }

    /**
     * Define el valor de la propiedad cordenada2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCordenada2(String value) {
        this.cordenada2 = value;
    }

    /**
     * Obtiene el valor de la propiedad cordenada3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCordenada3() {
        return cordenada3;
    }

    /**
     * Define el valor de la propiedad cordenada3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCordenada3(String value) {
        this.cordenada3 = value;
    }

    /**
     * Obtiene el valor de la propiedad cordenada4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCordenada4() {
        return cordenada4;
    }

    /**
     * Define el valor de la propiedad cordenada4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCordenada4(String value) {
        this.cordenada4 = value;
    }

}
