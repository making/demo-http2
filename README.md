# HTTP2 w/ Spring Boot + Undertow

    $ mvn clean package -Dmaven.test.skip=true
    $ java -Xbootclasspath/p:./alpn-boot-8.1.8.v20160420.jar -jar target/demo-0.0.1-SNAPSHOT.jar

Go [https://localhost:8443](https://localhost:8443)


    $ curl --http2 -k -v https://localhost:8443
    * Rebuilt URL to: https://localhost:8443/
    *   Trying ::1...
    * Connected to localhost (::1) port 8443 (#0)
    * ALPN, offering h2
    * ALPN, offering http/1.1
    * Cipher selection: ALL:!EXPORT:!EXPORT40:!EXPORT56:!aNULL:!LOW:!RC4:@STRENGTH
    * successfully set certificate verify locations:
    *   CAfile: /usr/local/etc/openssl/cert.pem
      CApath: none
    * TLSv1.2 (OUT), TLS header, Certificate Status (22):
    * TLSv1.2 (OUT), TLS handshake, Client hello (1):
    * TLSv1.2 (IN), TLS handshake, Server hello (2):
    * TLSv1.2 (IN), TLS handshake, Certificate (11):
    * TLSv1.2 (IN), TLS handshake, Server key exchange (12):
    * TLSv1.2 (IN), TLS handshake, Server finished (14):
    * TLSv1.2 (OUT), TLS handshake, Client key exchange (16):
    * TLSv1.2 (OUT), TLS change cipher, Client hello (1):
    * TLSv1.2 (OUT), TLS handshake, Finished (20):
    * TLSv1.2 (IN), TLS change cipher, Client hello (1):
    * TLSv1.2 (IN), TLS handshake, Finished (20):
    * SSL connection using TLSv1.2 / ECDHE-RSA-AES128-GCM-SHA256
    * ALPN, server accepted to use h2
    * Server certificate:
    * 	 subject: C=Unknown; ST=Unknown; L=Unknown; O=Unknown; OU=Unknown; CN=localhost
    * 	 start date: 2014-07-23 19:48:43 GMT
    * 	 expire date: 2014-10-21 19:48:43 GMT
    * 	 issuer: C=Unknown; ST=Unknown; L=Unknown; O=Unknown; OU=Unknown; CN=localhost
    * 	 SSL certificate verify result: self signed certificate (18), continuing anyway.
    * Using HTTP2, server supports multi-use
    * Connection state changed (HTTP/2 confirmed)
    * Copying HTTP/2 data in stream buffer to connection buffer after upgrade: len=0
    * Using Stream ID: 1 (easy handle 0x7fab0b002000)
    > GET / HTTP/1.1
    > Host: localhost:8443
    > User-Agent: curl/7.44.0
    > Accept: */*
    > 
    * http2_recv: 16384 bytes buffer at 0x7fab0b002930 (stream 1)
    * http2_recv: 16384 bytes buffer at 0x7fab0b002930 (stream 1)
    * http2_recv: 16384 bytes buffer at 0x7fab0b002930 (stream 1)
    * http2_recv: returns 115 for stream 1
    < HTTP/2.0 200
    < content-type:text/plain;charset=UTF-8
    < content-length:6
    < date:Fri, 21 Aug 2015 14:19:52 GMT
    < 
    * Connection #0 to host localhost left intact

## Reference

* http://undertow.io/blog/2015/03/26/HTTP2-In-Wildfly.html
* https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-undertow-ssl
* [Jetty version](https://github.com/otrosien/demo-http2)
