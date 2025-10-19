//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.19 a las 09:22:55 AM CEST 
//


package com.picoto.jaxb.verifactu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Datos de identificación de factura sustituida o rectificada. El NIF se cogerá del NIF indicado en el bloque IDFactura
 * 
 * <p>Clase Java para IDFacturaARType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="IDFacturaARType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IDEmisorFactura" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}NIFType"/&gt;
 *         &lt;element name="NumSerieFactura" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}TextoIDFacturaType"/&gt;
 *         &lt;element name="FechaExpedicionFactura" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}fecha"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDFacturaARType", propOrder = {
    "idEmisorFactura",
    "numSerieFactura",
    "fechaExpedicionFactura"
})
public class IDFacturaARType {

    @XmlElement(name = "IDEmisorFactura", required = true)
    protected String idEmisorFactura;
    @XmlElement(name = "NumSerieFactura", required = true)
    protected String numSerieFactura;
    @XmlElement(name = "FechaExpedicionFactura", required = true)
    protected String fechaExpedicionFactura;

    /**
     * Obtiene el valor de la propiedad idEmisorFactura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDEmisorFactura() {
        return idEmisorFactura;
    }

    /**
     * Define el valor de la propiedad idEmisorFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDEmisorFactura(String value) {
        this.idEmisorFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad numSerieFactura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSerieFactura() {
        return numSerieFactura;
    }

    /**
     * Define el valor de la propiedad numSerieFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSerieFactura(String value) {
        this.numSerieFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaExpedicionFactura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaExpedicionFactura() {
        return fechaExpedicionFactura;
    }

    /**
     * Define el valor de la propiedad fechaExpedicionFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaExpedicionFactura(String value) {
        this.fechaExpedicionFactura = value;
    }

}
