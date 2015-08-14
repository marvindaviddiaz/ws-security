
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
 *         &lt;element name="sesionId" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}stringRequiredForty"/>
 *         &lt;element name="facturador" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cobranza" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="servicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTrxColector" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idConsulta" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}stringRequiredForty"/>
 *         &lt;element name="camposCobranza" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}camposCobranza"/>
 *         &lt;element name="codigoIdioma" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}stringTwo"/>
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
    "facturador",
    "cobranza",
    "servicio",
    "idTrxColector",
    "idConsulta",
    "camposCobranza",
    "codigoIdioma"
})
@XmlRootElement(name = "GetBalanceRequest")
public class GetBalanceRequest {

    @XmlElement(required = true)
    protected String sesionId;
    protected int facturador;
    protected int cobranza;
    protected int servicio;
    protected long idTrxColector;
    @XmlElement(required = true)
    protected String idConsulta;
    @XmlElement(required = true)
    protected CamposCobranza camposCobranza;
    @XmlElement(required = true, nillable = true)
    protected String codigoIdioma;

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
     * Obtiene el valor de la propiedad facturador.
     * 
     */
    public int getFacturador() {
        return facturador;
    }

    /**
     * Define el valor de la propiedad facturador.
     * 
     */
    public void setFacturador(int value) {
        this.facturador = value;
    }

    /**
     * Obtiene el valor de la propiedad cobranza.
     * 
     */
    public int getCobranza() {
        return cobranza;
    }

    /**
     * Define el valor de la propiedad cobranza.
     * 
     */
    public void setCobranza(int value) {
        this.cobranza = value;
    }

    /**
     * Obtiene el valor de la propiedad servicio.
     * 
     */
    public int getServicio() {
        return servicio;
    }

    /**
     * Define el valor de la propiedad servicio.
     * 
     */
    public void setServicio(int value) {
        this.servicio = value;
    }

    /**
     * Obtiene el valor de la propiedad idTrxColector.
     * 
     */
    public long getIdTrxColector() {
        return idTrxColector;
    }

    /**
     * Define el valor de la propiedad idTrxColector.
     * 
     */
    public void setIdTrxColector(long value) {
        this.idTrxColector = value;
    }

    /**
     * Obtiene el valor de la propiedad idConsulta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdConsulta() {
        return idConsulta;
    }

    /**
     * Define el valor de la propiedad idConsulta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdConsulta(String value) {
        this.idConsulta = value;
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

    /**
     * Obtiene el valor de la propiedad codigoIdioma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoIdioma() {
        return codigoIdioma;
    }

    /**
     * Define el valor de la propiedad codigoIdioma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoIdioma(String value) {
        this.codigoIdioma = value;
    }

}
