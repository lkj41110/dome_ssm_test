package com.lk.connect;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Author: jiyanbin@betamail.net
 * Date: 10:39
 * JDK: 1.7
 */
public class StubGHBURLStreamHandler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new GHBProtocolConnection(u);
    }
}
