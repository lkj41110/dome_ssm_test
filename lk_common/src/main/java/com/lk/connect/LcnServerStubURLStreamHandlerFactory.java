package com.lk.connect;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * Author: jiyanbin@betamail.net
 * Date: 10:38
 * JDK: 1.7
 */
public class LcnServerStubURLStreamHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if (protocol.equalsIgnoreCase("ghb")) {
            return new StubGHBURLStreamHandler();
        }
        return null;
    }
}

