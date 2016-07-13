package com.alcatel.npm;

/**
 * Created by ocekmez on 3/21/2016.
 */
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public abstract class AbstractSecureWsHandler {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSecureWsHandler.class);

    /**
     * Enable Services for HTTPS Requests
     *
     * @param
     */
    public static void configureSecureTransaction() {
        Client client = null;
        HTTPConduit http = (HTTPConduit) client.getConduit();
        String targetAddress = http.getTarget().getAddress().getValue();
        logger.info("Receivedet Address [{}]", targetAddress);

        if (targetAddress.toLowerCase().startsWith("https:")) {
            logger.info("ExecutetManager for  HTTPS");
            TrustManager[] simpleTrustManager = new TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }};
            TLSClientParameters tlsParams = new TLSClientParameters();
            tlsParams.setTrustManagers(simpleTrustManager);
            tlsParams.setDisableCNCheck(true);
            http.setTlsClientParameters(tlsParams);
        }
    }
}