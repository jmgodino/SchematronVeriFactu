//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.26 a las 05:26:44 PM CET 
//


package com.picoto.jaxb.verifactu;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EstadoRegistroSFType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoRegistroSFType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Correcta"/&gt;
 *     &lt;enumeration value="AceptadaConErrores"/&gt;
 *     &lt;enumeration value="Anulada"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EstadoRegistroSFType")
@XmlEnum
public enum EstadoRegistroSFType {


    /**
     * El registro se ha almacenado sin errores
     * 
     */
    @XmlEnumValue("Correcta")
    CORRECTA("Correcta"),

    /**
     * El registro que se ha almacenado tiene algunos errores. Ver detalle del error
     * 
     */
    @XmlEnumValue("AceptadaConErrores")
    ACEPTADA_CON_ERRORES("AceptadaConErrores"),

    /**
     * El registro almacenado ha sido anulado
     * 
     */
    @XmlEnumValue("Anulada")
    ANULADA("Anulada");
    private final String value;

    EstadoRegistroSFType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoRegistroSFType fromValue(String v) {
        for (EstadoRegistroSFType c: EstadoRegistroSFType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
