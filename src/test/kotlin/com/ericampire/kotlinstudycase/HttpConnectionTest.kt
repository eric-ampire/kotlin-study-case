package com.ericampire.kotlinstudycase

import java.io.InputStream
import java.net.URL
import java.net.URLConnection
import java.net.URLStreamHandler
import java.net.URLStreamHandlerFactory

class HttpConnectionTest {
}

class StubStreamHandlerFactory : URLStreamHandlerFactory {
    override fun createURLStreamHandler(protocol: String): URLStreamHandler {
        return StubHttpUrlStreamHandler()
    }
}

class StubHttpUrlStreamHandler : URLStreamHandler() {
    override fun openConnection(url: URL): URLConnection {
        return StubHttpUrlConnexion(url)
    }
}

class StubHttpUrlConnexion(val url: URL) : URLConnection(url) {
    override fun connect() {
        TODO("Not yet implemented")
    }

    override fun getInputStream(): InputStream {
        return super.getInputStream()
    }
}