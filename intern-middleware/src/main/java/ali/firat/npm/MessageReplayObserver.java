package com.alcatel.npm;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.message.Message;
import org.junit.Assert;


import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ocekmez on 3/21/2016.
 */
public class MessageReplayObserver implements MessageObserver {
    String responseMessage;

    public MessageReplayObserver(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void onMessage(Message message) {
        try {

            InputStream in = message.getContent(InputStream.class);
            while (in.read() != -1) {
                // do nothing
            }
            in.close();

            Conduit backChannel = message.getDestination().getBackChannel(message);

            backChannel.prepare(message);

            OutputStream out = message.getContent(OutputStream.class);
            Assert.assertNotNull(out);
            InputStream res = getClass().getResourceAsStream(responseMessage);
            IOUtils.copy(res, out, 2045);

            res.close();
            out.close();
            backChannel.close(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}