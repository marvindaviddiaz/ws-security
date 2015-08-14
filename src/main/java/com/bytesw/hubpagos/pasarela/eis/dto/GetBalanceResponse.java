
package com.bytesw.hubpagos.pasarela.eis.dto;

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
 *         &lt;element name="error" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}error"/>
 *         &lt;element name="camposCobranza" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}camposCobranza"/>
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
    "camposCobranza"
})
@XmlRootElement(name = "GetBalanceResponse")
public class GetBalanceResponse {

    @XmlElement(required = true, nillable = true)
    protected Error error;
    @XmlElement(required = true, nillable = true)
    protected CamposCobranza camposCobranza;

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
     * Obtiene el valor de la propiedad camposCobranza.
     * 
     * @return
     *     possible object is
     *     {@link CamposCobranza }
     *     
     */
    public CamposCobranza getCamposCobranza() {
        return camposCobranza;
    }

    /**
     * Define el valor de la propiedad camposCobranza.
     * 
     * @param value
     *     allowed object is
     *     {@link CamposCobranza }
     *     
     */
    public void setCamposCobranza(CamposCobranza value) {
        this.camposCobranza = value;
    }

}
