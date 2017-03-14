package io.stack.pj;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.Properties;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    static Properties getProperties() {
        Properties props = new Properties();
        props.put("spring.config.location", "file:${catalina.home}/conf/");
        return props;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class)
                .properties(getProperties());
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .sources(Application.class)
                .properties(getProperties())
                .run(args);
    }
}
