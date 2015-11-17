package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration.EmbeddedServletContainerCustomizerBeanPostProcessorRegistrar;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.undertow.UndertowOptions;

@Configuration
// Avoiding @AutoConfiguration 
// and @ComponentScan for faster startup.
// @Import what was found using --debug
@Import({
    DispatcherServletAutoConfiguration.class,
    ErrorMvcAutoConfiguration.class,
    HttpEncodingAutoConfiguration.class,
    HttpMessageConvertersAutoConfiguration.class,
// matches, but not required:
//    JacksonAutoConfiguration.class,
//    JmxAutoConfiguration.class,
//    MultipartAutoConfiguration.class,
//    PropertyPlaceholderAutoConfiguration.class,
//  WebSocketAutoConfiguration.class,
    ServerPropertiesAutoConfiguration.class,
    WebMvcAutoConfiguration.class,
    EmbeddedServletContainerCustomizerBeanPostProcessorRegistrar.class
})
public class DemoHttp2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoHttp2Application.class, args);
    }

    @Bean
    UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers(
                builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
        return factory;
    }

    @Bean
    public HelloController helloBean() {
        return new HelloController();
    }
}

@RestController
class HelloController {

    @RequestMapping
    String hello() {
        return "hello!";
    }
}