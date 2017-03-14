package io.stack.pj.config;

import io.stack.pj.project.ProjectPackage;
import io.stack.pj.record.RecordPackage;
import io.stack.pj.shared.DefaultNamingStrategy;
import io.stack.pj.user.UserPackage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackageClasses = {UserPackage.class, RecordPackage.class, ProjectPackage.class})
@EnableJpaRepositories(basePackageClasses = {UserPackage.class, RecordPackage.class, ProjectPackage.class},
        entityManagerFactoryRef = "pmEMF", transactionManagerRef = "pmTxnManager")
@EnableSpringDataWebSupport
public class DatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:hsqldb:file:~/hsqldb/project_manager_db;DB_CLOSE_ON_EXIT=FALSE");
        return dataSource;
        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .build();
    }

    @Bean(name = "pmEMF")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan(new String[]{UserPackage.class.getPackage().getName(), RecordPackage.class.getPackage().getName(),
                ProjectPackage.class.getPackage().getName()});
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setPersistenceUnitName("pu-project-manager");
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties());
        return entityManagerFactoryBean;
    }

    @Bean(name = "pmTxnManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        props.put("hibernate.physical_naming_strategy", DefaultNamingStrategy.class.getName());
        return props;
    }
}
