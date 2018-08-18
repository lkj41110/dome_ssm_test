package com.lk.connect;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Author: jiyanbin@betamail.net
 * Date: 9:55
 * JDK: 1.7
 *
 * Get heartbeat connection.
 *
 * To handle Get heartbeat(GHB) Protocol
 */
public class GHBProtocolConnection extends StubAbstractProtocolConnection {

    public GHBProtocolConnection(URL url) {
        super(url);
    }

    public InputStream getInputStream() throws IOException {
        return getHeartBeat();
    }

    @Override
    public int getResponseCode() throws IOException {
        return 200;
    }

    private InputStream getHeartBeat() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n" +
                "    \"code\": \"100\",\n" +
                "    \"lastTimeStamp\": " + System.currentTimeMillis() + ",\n" +
                "    \"ip\": \"localhost\",\n" +
                "    \"sn\": 1394172879623\n" +
                "}\n");
        return new ByteArrayInputStream(encode(sb.toString()));
    }

}
