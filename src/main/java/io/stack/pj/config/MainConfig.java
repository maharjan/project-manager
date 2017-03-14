package io.stack.pj.config;

import io.stack.pj.aop.AOPPackage;
import io.stack.pj.project.ProjectPackage;
import io.stack.pj.record.RecordPackage;
import io.stack.pj.setting.SettingPackage;
import io.stack.pj.user.UserPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Configuration
@Import(value = {SwaggerConfig.class, SecurityConfig.class, DatasourceConfig.class})
@ComponentScan(basePackageClasses = {SettingPackage.class, RecordPackage.class, UserPackage.class, ProjectPackage.class, AOPPackage.class})
public class MainConfig {

}
