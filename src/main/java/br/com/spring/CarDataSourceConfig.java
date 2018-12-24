package br.com.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        basePackages = {"br.com.spring.car"},
        entityManagerFactoryRef = "emf2", 
        transactionManagerRef = "tm2")
@EnableTransactionManagement
public class CarDataSourceConfig {
	
	@Bean(name = "datasource2")
	@ConfigurationProperties("database2.datasource")
	public DataSource dataSource(){
	    return DataSourceBuilder.create().build();
	}

    @Bean(name = "tm2")
    public PlatformTransactionManager transactionManager1() {
        return new JpaTransactionManager(entityManagerFactory1().getObject());
    }
 
    @Bean(name = "emf2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {
 
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
 
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        //FOR TEST USAGE
        factoryBean.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "create-drop");
       
        factoryBean.setPackagesToScan("br.com.spring.car");
        factoryBean.setPersistenceUnitName("db2");
 
        return factoryBean;
    }	
	
}
