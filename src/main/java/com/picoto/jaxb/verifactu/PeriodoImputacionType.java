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
 * <p>Clase Java para PeriodoImputacionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PeriodoImputacionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ejercicio" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}YearType"/&gt;
 *         &lt;element name="Periodo" type="{https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/tike/cont/ws/SuministroInformacion.xsd}TipoPeriodoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodoImputacionType", propOrder = {
    "ejercicio",
    "periodo"
})
public class PeriodoImputacionType {

    @XmlElement(name = "Ejercicio", required = true)
    protected String ejercicio;
    @XmlElement(name = "Periodo", required = true)
    protected String periodo;

    /**
     * Obtiene el valor de la propiedad ejercicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEjercicio() {
        return ejercicio;
    }

    /**
     * Define el valor de la propiedad ejercicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEjercicio(String value) {
        this.ejercicio = value;
    }

    /**
     * Obtiene el valor de la propiedad periodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Define el valor de la propiedad periodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodo(String value) {
        this.periodo = value;
    }

}
