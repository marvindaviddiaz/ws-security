
package com.bytesw.hubpagos.pasarela.eis.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
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
 *         &lt;element name="camposCobranza" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}camposCobranza"/>
 *         &lt;element name="subTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="impuestos" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="autorizacionDebitoColector" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idPago" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}stringRequiredForty"/>
 *         &lt;element name="moneda" type="{http://dto.eis.pasarela.hubpagos.bytesw.com/}stringRequiredThree"/>
 *         &lt;element name="numeroCuenta" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="producto" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "camposCobranza",
    "subTotal",
    "impuestos",
    "total",
    "autorizacionDebitoColector",
    "idPago",
    "moneda",
    "numeroCuenta",
    "producto",
    "codigoIdioma"
})
@XmlRootElement(name = "PayBillRequest")
public class PayBillRequest {

    @XmlElement(required = true)
    protected String sesionId;
    protected int facturador;
    protected int cobranza;
    protected int servicio;
    protected long idTrxColector;
    @XmlElement(required = true)
    protected CamposCobranza camposCobranza;
    @XmlElement(required = true)
    protected BigDecimal subTotal;
    @XmlElement(required = true)
    protected BigDecimal impuestos;
    @XmlElement(required = true)
    protected BigDecimal total;
    protected long autorizacionDebitoColector;
    @XmlElement(required = true)
    protected String idPago;
    @XmlElement(required = true)
    protected String moneda;
    @XmlElement(required = true, nillable = true)
    protected BigInteger numeroCuenta;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer producto;
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
     * Obtiene el valor de la propiedad subTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * Define el valor de la propiedad subTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubTotal(BigDecimal value) {
        this.subTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad impuestos.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImpuestos() {
        return impuestos;
    }

    /**
     * Define el valor de la propiedad impuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImpuestos(BigDecimal value) {
        this.impuestos = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad autorizacionDebitoColector.
     * 
     */
    public long getAutorizacionDebitoColector() {
        return autorizacionDebitoColector;
    }

    /**
     * Define el valor de la propiedad autorizacionDebitoColector.
     * 
     */
    public void setAutorizacionDebitoColector(long value) {
        this.autorizacionDebitoColector = value;
    }

    /**
     * Obtiene el valor de la propiedad idPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPago() {
        return idPago;
    }

    /**
     * Define el valor de la propiedad idPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPago(String value) {
        this.idPago = value;
    }

    /**
     * Obtiene el valor de la propiedad moneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Define el valor de la propiedad moneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneda(String value) {
        this.moneda = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroCuenta.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Define el valor de la propiedad numeroCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroCuenta(BigInteger value) {
        this.numeroCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad producto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProducto() {
        return producto;
    }

    /**
     * Define el valor de la propiedad producto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProducto(Integer value) {
        this.producto = value;
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
