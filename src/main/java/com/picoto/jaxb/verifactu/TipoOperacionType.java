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
 * <p>Clase Java para TipoOperacionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoOperacionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Alta"/&gt;
 *     &lt;enumeration value="Anulacion"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoOperacionType")
@XmlEnum
public enum TipoOperacionType {


    /**
     * La operación realizada ha sido un alta
     * 
     */
    @XmlEnumValue("Alta")
    ALTA("Alta"),

    /**
     * La operación realizada ha sido una anulación
     * 
     */
    @XmlEnumValue("Anulacion")
    ANULACION("Anulacion");
    private final String value;

    TipoOperacionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoOperacionType fromValue(String v) {
        for (TipoOperacionType c: TipoOperacionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
