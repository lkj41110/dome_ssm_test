package com.lk.connect;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: jiyanbin@betamail.net
 * Date: 9:57
 * JDK: 1.7
 */
public abstract class StubAbstractProtocolConnection extends HttpURLConnection {
    String header = "HTTP/1.1 200 OK \r\n" +
            "Content-type: application/json\r\n\r\n";
    String errorHeader = "HTTP/1.1 400 Client Error \r\n";
    byte[] code;

    public StubAbstractProtocolConnection(URL url) {
        super(url);
    }

    //protected CoderWrapper coderWrapper = new CoderWrapper(new RSACoder());

    protected byte[] encode(String text) {
        try {
            //byte[] temp = coderWrapper.encryptDataByRSA("", text.getBytes(), Coder.PRIVATE_KEY);
            //byte[] code = Coder.encryptBASE64(temp).getBytes();
            byte[] headerBytes = header.getBytes();
            byte[] bytes = new byte[headerBytes.length + code.length];
            System.arraycopy(headerBytes, 0, bytes, 0, headerBytes.length);
            System.arraycopy(code, 0, bytes, headerBytes.length, code.length);
            return bytes;
            //return code;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
