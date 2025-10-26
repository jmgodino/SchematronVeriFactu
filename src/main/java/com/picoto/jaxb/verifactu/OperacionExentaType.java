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
 * <p>Clase Java para OperacionExentaType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="OperacionExentaType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="E1"/&gt;
 *     &lt;enumeration value="E2"/&gt;
 *     &lt;enumeration value="E3"/&gt;
 *     &lt;enumeration value="E4"/&gt;
 *     &lt;enumeration value="E5"/&gt;
 *     &lt;enumeration value="E6"/&gt;
 *     &lt;enumeration value="E7"/&gt;
 *     &lt;enumeration value="E8"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OperacionExentaType")
@XmlEnum
public enum OperacionExentaType {

    @XmlEnumValue("E1")
    E_1("E1"),
    @XmlEnumValue("E2")
    E_2("E2"),
    @XmlEnumValue("E3")
    E_3("E3"),
    @XmlEnumValue("E4")
    E_4("E4"),
    @XmlEnumValue("E5")
    E_5("E5"),
    @XmlEnumValue("E6")
    E_6("E6"),
    @XmlEnumValue("E7")
    E_7("E7"),
    @XmlEnumValue("E8")
    E_8("E8");
    private final String value;

    OperacionExentaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperacionExentaType fromValue(String v) {
        for (OperacionExentaType c: OperacionExentaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
