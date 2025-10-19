//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.19 a las 09:22:55 AM CEST 
//


package com.picoto.jaxb.verifactu;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CalificacionOperacionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CalificacionOperacionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="S1"/&gt;
 *     &lt;enumeration value="S2"/&gt;
 *     &lt;enumeration value="N1"/&gt;
 *     &lt;enumeration value="N2"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CalificacionOperacionType")
@XmlEnum
public enum CalificacionOperacionType {


    /**
     *  OPERACIÓN SUJETA Y NO EXENTA - SIN INVERSIÓN DEL SUJETO PASIVO.
     * 
     */
    @XmlEnumValue("S1")
    S_1("S1"),

    /**
     * OPERACIÓN SUJETA Y NO EXENTA - CON INVERSIÓN DEL SUJETO PASIVO
     * 
     */
    @XmlEnumValue("S2")
    S_2("S2"),

    /**
     * OPERACIÓN NO SUJETA ARTÍCULO 7, 14, OTROS.
     * 
     */
    @XmlEnumValue("N1")
    N_1("N1"),

    /**
     * OPERACIÓN NO SUJETA POR REGLAS DE LOCALIZACIÓN
     * 
     */
    @XmlEnumValue("N2")
    N_2("N2");
    private final String value;

    CalificacionOperacionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CalificacionOperacionType fromValue(String v) {
        for (CalificacionOperacionType c: CalificacionOperacionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
