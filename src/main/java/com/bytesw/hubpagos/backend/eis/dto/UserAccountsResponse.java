
package com.bytesw.hubpagos.backend.eis.dto;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="cuentas" type="{http://dto.eis.backend.hubpagos.bytesw.com/}cuenta" maxOccurs="unbounded" minOccurs="0"/>
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
    "cuentas"
})
@XmlRootElement(name = "UserAccountsResponse")
public class UserAccountsResponse {

    @XmlElement(required = true, nillable = true)
    protected Error error;
    @XmlElement(nillable = true)
    protected List<Cuenta> cuentas;

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
     * Gets the value of the cuentas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cuentas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCuentas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cuenta }
     * 
     * 
     */
    public List<Cuenta> getCuentas() {
        if (cuentas == null) {
            cuentas = new ArrayList<Cuenta>();
        }
        return this.cuentas;
    }

}
