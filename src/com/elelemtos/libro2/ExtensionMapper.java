/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:06:07 GMT)
 */
package com.elelemtos.libro2;


/**
 *  ExtensionMapper class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ExtensionMapper {
    public static java.lang.Object getTypeObject(
        java.lang.String namespaceURI, java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
        if ("http://elelemtos.com/Libro2/".equals(namespaceURI) &&
                "libro".equals(typeName)) {
            return com.elelemtos.libro2.Libro.Factory.parse(reader);
        }

        if ("http://elelemtos.com/Libro2/".equals(namespaceURI) &&
                "codigo".equals(typeName)) {
            return com.elelemtos.libro2.Codigo.Factory.parse(reader);
        }

        if ("http://elelemtos.com/Libro2/".equals(namespaceURI) &&
                "listaLibros".equals(typeName)) {
            return com.elelemtos.libro2.ListaLibros.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
