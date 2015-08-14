
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
 *         &lt;element name="autorizacionDebito" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="motivo" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredOneHundred"/>
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
    "autorizacionDebito",
    "motivo"
})
@XmlRootElement(name = "ReverseChargeRequest")
public class ReverseChargeRequest {

    @XmlElement(required = true)
    protected String sesionId;
    @XmlElement(required = true)
    protected String userAlias;
    protected long autorizacionDebito;
    @XmlElement(required = true)
    protected String motivo;

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
     * Obtiene el valor de la propiedad autorizacionDebito.
     * 
     */
    public long getAutorizacionDebito() {
        return autorizacionDebito;
    }

    /**
     * Define el valor de la propiedad autorizacionDebito.
     * 
     */
    public void setAutorizacionDebito(long value) {
        this.autorizacionDebito = value;
    }

    /**
     * Obtiene el valor de la propiedad motivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Define el valor de la propiedad motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

}
