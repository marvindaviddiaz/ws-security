
package com.bytesw.hubpagos.backend.eis.dto;

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
 *         &lt;element name="sesionId" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredForty"/>
 *         &lt;element name="userAlias" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredForty"/>
 *         &lt;element name="numeroCuenta" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="producto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="moneda" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredThree"/>
 *         &lt;element name="fechaVencimientoTC" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cvv2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="montoSinImpuesto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="impuesto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="totalDebitar" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="cobranza" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreCobranza" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredSixty"/>
 *         &lt;element name="idPago" type="{http://dto.eis.backend.hubpagos.bytesw.com/}stringRequiredTwenty"/>
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
    "numeroCuenta",
    "producto",
    "moneda",
    "fechaVencimientoTC",
    "cvv2",
    "montoSinImpuesto",
    "impuesto",
    "totalDebitar",
    "cobranza",
    "nombreCobranza",
    "idPago"
})
@XmlRootElement(name = "ChargeAccountRequest")
public class ChargeAccountRequest {

    @XmlElement(required = true)
    protected String sesionId;
    @XmlElement(required = true)
    protected String userAlias;
    @XmlElement(required = true)
    protected BigInteger numeroCuenta;
    protected int producto;
    @XmlElement(required = true)
    protected String moneda;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer fechaVencimientoTC;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cvv2;
    @XmlElement(required = true)
    protected BigDecimal montoSinImpuesto;
    @XmlElement(required = true)
    protected BigDecimal impuesto;
    @XmlElement(required = true)
    protected BigDecimal totalDebitar;
    protected int cobranza;
    @XmlElement(required = true)
    protected String nombreCobranza;
    @XmlElement(required = true)
    protected String idPago;

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
     */
    public int getProducto() {
        return producto;
    }

    /**
     * Define el valor de la propiedad producto.
     * 
     */
    public void setProducto(int value) {
        this.producto = value;
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
     * Obtiene el valor de la propiedad fechaVencimientoTC.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFechaVencimientoTC() {
        return fechaVencimientoTC;
    }

    /**
     * Define el valor de la propiedad fechaVencimientoTC.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFechaVencimientoTC(Integer value) {
        this.fechaVencimientoTC = value;
    }

    /**
     * Obtiene el valor de la propiedad cvv2.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCvv2() {
        return cvv2;
    }

    /**
     * Define el valor de la propiedad cvv2.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCvv2(Integer value) {
        this.cvv2 = value;
    }

    /**
     * Obtiene el valor de la propiedad montoSinImpuesto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoSinImpuesto() {
        return montoSinImpuesto;
    }

    /**
     * Define el valor de la propiedad montoSinImpuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoSinImpuesto(BigDecimal value) {
        this.montoSinImpuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad impuesto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImpuesto() {
        return impuesto;
    }

    /**
     * Define el valor de la propiedad impuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImpuesto(BigDecimal value) {
        this.impuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad totalDebitar.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDebitar() {
        return totalDebitar;
    }

    /**
     * Define el valor de la propiedad totalDebitar.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDebitar(BigDecimal value) {
        this.totalDebitar = value;
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
     * Obtiene el valor de la propiedad nombreCobranza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCobranza() {
        return nombreCobranza;
    }

    /**
     * Define el valor de la propiedad nombreCobranza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCobranza(String value) {
        this.nombreCobranza = value;
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

}
