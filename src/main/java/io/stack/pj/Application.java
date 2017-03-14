package io.stack.pj;

import io.stack.pj.config.MainConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Import(value = MainConfig.class)
@SpringBootApplication
@EnableAutoConfiguration( exclude = {
        DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class
})
public class Application extends SpringBootServletInitializer {

//    static Properties getProperties() {
//        Properties props = new Properties();
//        props.put("spring.config.location", "file:${catalina.home}/conf/projectmanager.properties");
//        return props;
//    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
//                .properties(getProperties());
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .sources(Application.class)
//                .properties(getProperties())
                .run(args);
    }
}
