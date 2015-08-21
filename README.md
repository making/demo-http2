# HTTP2 w/ Spring Boot + Undertow

    $ mvn clean package -Dmaven.test.skip=true
    $ java -Xbootclasspath/p:./alpn-boot-8.1.3.v20150130.jar -jar target/demo-0.0.1-SNAPSHOT.jar

Go [https://localhost:8433](https://localhost:8433)


## Reference

* http://undertow.io/blog/2015/03/26/HTTP2-In-Wildfly.html
* https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-undertow-ssl
