//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.26 a las 05:26:44 PM CET 
//


package com.picoto.jaxb.verifactu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Desglose de Base y Cuota sustituida en las Facturas Rectificativas sustitutivas
 * 
 * <p>Clase Java para DesgloseRectificacionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DesgloseRectificacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BaseRectificada" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}ImporteSgn12.2Type"/&gt;
 *         &lt;element name="CuotaRectificada" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}ImporteSgn12.2Type"/&gt;
 *         &lt;element name="CuotaRecargoRectificado" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}ImporteSgn12.2Type" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DesgloseRectificacionType", propOrder = {
    "baseRectificada",
    "cuotaRectificada",
    "cuotaRecargoRectificado"
})
public class DesgloseRectificacionType {

    @XmlElement(name = "BaseRectificada", required = true)
    protected String baseRectificada;
    @XmlElement(name = "CuotaRectificada", required = true)
    protected String cuotaRectificada;
    @XmlElement(name = "CuotaRecargoRectificado")
    protected String cuotaRecargoRectificado;

    /**
     * Obtiene el valor de la propiedad baseRectificada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseRectificada() {
        return baseRectificada;
    }

    /**
     * Define el valor de la propiedad baseRectificada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseRectificada(String value) {
        this.baseRectificada = value;
    }

    /**
     * Obtiene el valor de la propiedad cuotaRectificada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuotaRectificada() {
        return cuotaRectificada;
    }

    /**
     * Define el valor de la propiedad cuotaRectificada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuotaRectificada(String value) {
        this.cuotaRectificada = value;
    }

    /**
     * Obtiene el valor de la propiedad cuotaRecargoRectificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuotaRecargoRectificado() {
        return cuotaRecargoRectificado;
    }

    /**
     * Define el valor de la propiedad cuotaRecargoRectificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuotaRecargoRectificado(String value) {
        this.cuotaRecargoRectificado = value;
    }

}
