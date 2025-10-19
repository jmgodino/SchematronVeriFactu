//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.19 a las 09:22:55 AM CEST 
//


package com.picoto.jaxb.verifactu;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClaveTipoRectificativaType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ClaveTipoRectificativaType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ClaveTipoRectificativaType")
@XmlEnum
public enum ClaveTipoRectificativaType {


    /**
     * SUSTITUTIVA
     * 
     */
    S,

    /**
     * INCREMENTAL
     * 
     */
    I;

    public String value() {
        return name();
    }

    public static ClaveTipoRectificativaType fromValue(String v) {
        return valueOf(v);
    }

}
