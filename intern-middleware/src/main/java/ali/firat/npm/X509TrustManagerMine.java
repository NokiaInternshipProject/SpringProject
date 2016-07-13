package com.alcatel.npm;
import org.apache.cxf.configuration.jsse.TLSClientParameters;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * Created by ocekmez on 3/21/2016.
 */
public class X509TrustManagerMine implements X509TrustManager {
    public static TLSClientParameters TlsClientParameters;

    static {
        X509TrustManager[] x509TrustManagers = new X509TrustManagerMine[]{new X509TrustManagerMine()};
        TlsClientParameters = new TLSClientParameters();
        TlsClientParameters.setDisableCNCheck(true);
        TlsClientParameters.setTrustManagers(x509TrustManagers);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        System.out.println("getAcceptedIssuers works");
        return new X509Certificate[0];
    }

    public void checkClientTrusted(X509Certificate[] certs, String authType) {
      //  System.out.println("checkClientTrusted works");
    }

    public void checkServerTrusted(X509Certificate[] certs, String authType) {
       // System.out.println("checkClientServer works");
    }
}
