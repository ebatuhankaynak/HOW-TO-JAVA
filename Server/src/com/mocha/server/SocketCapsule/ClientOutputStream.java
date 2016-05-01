package com.mocha.server.SocketCapsule;

import java.io.*;

public class ClientOutputStream extends PrintWriter {

    public ClientOutputStream(OutputStream outputStream) {
        super(outputStream, true);
    }

}
