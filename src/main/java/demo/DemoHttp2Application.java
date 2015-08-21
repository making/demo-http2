package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.undertow.UndertowOptions;

@SpringBootApplication
@RestController
public class DemoHttp2Application {

    @Bean
    public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
        final UndertowEmbeddedServletContainerFactory undertowEmbeddedServletContainerFactory = new UndertowEmbeddedServletContainerFactory();
        undertowEmbeddedServletContainerFactory
                .addBuilderCustomizers(builder -> {
                    builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true);
                });
        return undertowEmbeddedServletContainerFactory;
    }

    @RequestMapping
    String hello() {
        return "hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoHttp2Application.class, args);
    }
}
