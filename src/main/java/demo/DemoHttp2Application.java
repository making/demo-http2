package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.undertow.UndertowOptions;

@Configuration
@EnableAutoConfiguration
/*  
// Enable, if you want to avoid @AutoConfiguration 
//and @ComponentScan for faster startup.
//@Imports were found by running with --debug
@Import({
 DispatcherServletAutoConfiguration.class,
 ErrorMvcAutoConfiguration.class,
 HttpEncodingAutoConfiguration.class,
 HttpMessageConvertersAutoConfiguration.class,
// here are matches, which are not required:
// JacksonAutoConfiguration.class,
// JmxAutoConfiguration.class,
// MultipartAutoConfiguration.class,
// PropertyPlaceholderAutoConfiguration.class,
//WebSocketAutoConfiguration.class,
 ServerPropertiesAutoConfiguration.class,
 WebMvcAutoConfiguration.class,
 EmbeddedServletContainerCustomizerBeanPostProcessorRegistrar.class
})
*/
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
    public HelloController helloControllerBean() {
        return new HelloController();
    }
}

@RestController
class HelloController {

    @RequestMapping(path="/")
    String hello() {
        return "hello!";
    }
}