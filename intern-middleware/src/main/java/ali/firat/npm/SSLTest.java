package com.alcatel.npm;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by ocekmez on 3/21/2016.
 */
public class SSLTest implements HostnameVerifier {
    @Override
    public boolean verify(String s, SSLSession sslSession) {
        if (s.equals("10.33.198.201"))
            return true;

        return false;
    }
}
