package com.alcatel.npm;


import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.jaxws.ServiceImpl;
import org.apache.cxf.transport.http.HTTPConduit;
import org.xml.sax.SAXException;

import javax.net.ssl.*;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLStreamException;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by ocekmez on 3/21/2016.
 */
public class CXFTestSubs  {


    /*
    * java 8
    * static {
    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> hostname.equals("127.0.0.1"));
}
    * */

    public static TLSClientParameters TlsClientParameters;

    static {
        X509TrustManager[] x509TrustManagers = new X509TrustManagerMine[]{new X509TrustManagerMine()};
        TlsClientParameters = new TLSClientParameters();
        TlsClientParameters.setDisableCNCheck(true);
        TlsClientParameters.setTrustManagers(x509TrustManagers);


    }




    private static final QName serviceName = new QName("urn:SubscriberService/", "SubscriberService");
    private final static QName portName = new QName("urn:SubscriberService/", "BindingSOAP");//portlar zaten ServiceImpl debugdayken gozukuyor
    // private final static QName portName = new QName("http://npm.redback.com", "SessionMgmtIfcPort");//portlar zaten ServiceImpl debugdayken gozukuyor


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, SOAPException, XMLStreamException, NoSuchAlgorithmException, KeyManagementException {
    CXFTestSubs cxfTestSubs = new CXFTestSubs();

        ServiceImpl service =
                new ServiceImpl(null, CXFTestSubs.class.getResource("/SubscriberService.wsdl"), serviceName, null);

        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapReq1 = factory.createMessage(null, new FileInputStream("C:\\home\\input.xml"));
        Dispatch<SOAPMessage> dispSOAPMsg1 = service.createDispatch(portName,
                SOAPMessage.class, Service.Mode.MESSAGE);

        HTTPConduit conduit = (HTTPConduit) ((org.apache.cxf.jaxws.DispatchImpl) dispSOAPMsg1).getClient().getConduit();
        conduit.setTlsClientParameters(TlsClientParameters);

        MimeHeaders headers = soapReq1.getMimeHeaders();
        dispSOAPMsg1.getRequestContext().put("find.dispatch.operation", Boolean.TRUE);
        //message.get(TLSClientParameters.class) BURASI normalde null kendimizinkini koysak bitecek bunu cagiriyor cunku: tlsClientParameters.getTrustManagers()
        //HttpsURLConnectionFactory. ctx.init burada trustManager null oyuzden default koyuyor
        soapReq1.setProperty(TLSClientParameters.class.toString(), CXFTestSubs.TlsClientParameters);
        System.out.println("Invoking server through Dispatch interface using SOAPMessage");
        dispSOAPMsg1.getRequestContext().put(Dispatch.SOAPACTION_URI_PROPERTY, "tns:getAllIPFromRouter");
        SOAPMessage soapMessage = dispSOAPMsg1.invoke(soapReq1);
        //  DOMSource source = new DOMSource(doc);
        //  Source res = disp.invoke(source);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        soapMessage.writeTo(out);
        String strMsg = new String(out.toByteArray());

    }
}


