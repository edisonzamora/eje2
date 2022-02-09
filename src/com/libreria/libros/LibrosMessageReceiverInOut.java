/**
 * LibrosMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.libreria.libros;


/**
 *  LibrosMessageReceiverInOut message receiver
 */
public class LibrosMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            LibrosSkeleton skel = (LibrosSkeleton) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("listaLibrosO".equals(methodName)) {
                    com.elelemtos.libro2.LibrosResponse librosResponse9 = null;
                    com.elelemtos.libro2.LibrosRequest wrappedParam = (com.elelemtos.libro2.LibrosRequest) fromOM(msgContext.getEnvelope()
                                                                                                                            .getBody()
                                                                                                                            .getFirstElement(),
                            com.elelemtos.libro2.LibrosRequest.class);

                    librosResponse9 = skel.listaLibrosO(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            librosResponse9, false,
                            new javax.xml.namespace.QName(
                                "http://elelemtos.com/Libro2/", "librosResponse"));
                } else
                 if ("buscarLibroPorCodigoO".equals(methodName)) {
                    com.elelemtos.libro2.CodigolibroResponse codigolibroResponse11 =
                        null;
                    com.elelemtos.libro2.CodigolibroRequest wrappedParam = (com.elelemtos.libro2.CodigolibroRequest) fromOM(msgContext.getEnvelope()
                                                                                                                                      .getBody()
                                                                                                                                      .getFirstElement(),
                            com.elelemtos.libro2.CodigolibroRequest.class);

                    codigolibroResponse11 = skel.buscarLibroPorCodigoO(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            codigolibroResponse11, false,
                            new javax.xml.namespace.QName(
                                "http://elelemtos.com/Libro2/",
                                "codigolibroResponse"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(
        com.elelemtos.libro2.LibrosRequest param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.elelemtos.libro2.LibrosRequest.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.elelemtos.libro2.LibrosResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.elelemtos.libro2.LibrosResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.elelemtos.libro2.CodigolibroRequest param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.elelemtos.libro2.CodigolibroRequest.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.elelemtos.libro2.CodigolibroResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.elelemtos.libro2.CodigolibroResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.elelemtos.libro2.LibrosResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.elelemtos.libro2.LibrosResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private com.elelemtos.libro2.LibrosResponse wraplistaLibrosO() {
        com.elelemtos.libro2.LibrosResponse wrappedElement = new com.elelemtos.libro2.LibrosResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.elelemtos.libro2.CodigolibroResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.elelemtos.libro2.CodigolibroResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private com.elelemtos.libro2.CodigolibroResponse wrapbuscarLibroPorCodigoO() {
        com.elelemtos.libro2.CodigolibroResponse wrappedElement = new com.elelemtos.libro2.CodigolibroResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (com.elelemtos.libro2.CodigolibroRequest.class.equals(type)) {
                return com.elelemtos.libro2.CodigolibroRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.elelemtos.libro2.CodigolibroResponse.class.equals(type)) {
                return com.elelemtos.libro2.CodigolibroResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.elelemtos.libro2.LibrosRequest.class.equals(type)) {
                return com.elelemtos.libro2.LibrosRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.elelemtos.libro2.LibrosResponse.class.equals(type)) {
                return com.elelemtos.libro2.LibrosResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class
