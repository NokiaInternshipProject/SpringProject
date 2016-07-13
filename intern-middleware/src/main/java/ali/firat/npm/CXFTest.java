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
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
/**
 * Created by ocekmez on 3/21/2016.
 */
public class CXFTest {


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

    //ortaklari netOp service diye bir sey yapacagiz, ondan sonra new'ile olusturacagimiz bir sinifa
    //netOp service'e service, messageFactory'i set edebiliriz, alacagi ip ile sorgu yapabilir, netOp operation sinifi yapabiliriz.
    //operation sinifina netOp service'i veririz?

    private static final QName SERVICE_NAME = new QName("http://nbi2.service.hdm.alcatel.com/", "NBIService");
    private final static QName serviceName = new QName("http://npm.redback.com", "NPMAPI");//target namespacedeki var
    private final static QName portName = new QName("http://npm.redback.com", "SessionMgmtIfcPort");//portlar zaten ServiceImpl debugdayken gozukuyor

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, SOAPException, XMLStreamException, NoSuchAlgorithmException, KeyManagementException {
        ServiceImpl service =
                new ServiceImpl(null, CXFTest.class.getResource("/user_mgmt.wsdl"), serviceName, null);

        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapReq1 = factory.createMessage(null, new FileInputStream("C:\\home\\input2.xml"));
        Dispatch<SOAPMessage> dispSOAPMsg1 = service.createDispatch(portName,
                SOAPMessage.class, Service.Mode.MESSAGE);

        HTTPConduit conduit = (HTTPConduit) ((org.apache.cxf.jaxws.DispatchImpl) dispSOAPMsg1).getClient().getConduit();
        conduit.setTlsClientParameters(TlsClientParameters);

        MimeHeaders headers = soapReq1.getMimeHeaders();
        dispSOAPMsg1.getRequestContext().put(Dispatch.SOAPACTION_URI_PROPERTY, "getSubscriberSessionsByIPAddr");
        /*
            Map<String, List<String>> headerList = new HashMap<String, List<String>>();
            headerList.put("SOAPAction", Arrays.asList("npm:getSubscriberSessionsByIPAddr"));
            dispatch2.getRequestContext().put(Message.PROTOCOL_HEADERS, headerList);
        */
        dispSOAPMsg1.getRequestContext().put("find.dispatch.operation", Boolean.TRUE);
        //message.get(TLSClientParameters.class) BURASI normalde null kendimizinkini koysak bitecek bunu cagiriyor cunku: tlsClientParameters.getTrustManagers()
        //HttpsURLConnectionFactory. ctx.init burada trustManager null oyuzden default koyuyor
        soapReq1.setProperty(TLSClientParameters.class.toString(), CXFTestSubs.TlsClientParameters);
        System.out.println("Invoking server through Dispatch interface using SOAPMessage");
        SOAPMessage soapMessage = dispSOAPMsg1.invoke(soapReq1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        soapMessage.writeTo(out);
        String strMsg = new String(out.toByteArray());

        System.out.println(strMsg);
    }
}


