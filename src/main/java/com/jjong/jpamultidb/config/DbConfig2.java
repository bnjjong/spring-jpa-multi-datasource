/*
 * Created By dogfootmaster@gmail.com on 2022
 * This program is free software
 *
 * @author <a href=“mailto:dogfootmaster@gmail.com“>Jongsang Han</a>
 * @since 2022/02/19
 */

package com.jjong.jpamultidb.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * create on 2022/02/19. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author Jongsang Han
 * @version 1.0
 * @see
 * @since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "spring.db2.datasource")
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory2",
    transactionManagerRef = "transactionManager2",
    basePackages = {"com.jjong.jpamultidb.db2.repository"}
)
public class DbConfig2 extends HikariConfig {

  @Bean
  public DataSource dataSource2() {
    return new LazyConnectionDataSourceProxy(new HikariDataSource(this));
  }

  @Bean
  public EntityManagerFactory entityManagerFactory2() {
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(this.dataSource2());
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setJpaPropertyMap(Map.of(
        "hibernate.hbm2ddl.auto", "create",
        "hibernate.dialect", "org.hibernate.dialect.MariaDB103Dialect",
        "hibernate.show_sql", "true",
        "hibernate.format_sql", "true"
    ));

    factory.setPackagesToScan("com.jjong.jpamultidb.db2.domain");
    factory.setPersistenceUnitName("db2");
    factory.afterPropertiesSet();

    return factory.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager2() {
    JpaTransactionManager tm = new JpaTransactionManager();
    tm.setEntityManagerFactory(entityManagerFactory2());
    return tm;
  }

}
