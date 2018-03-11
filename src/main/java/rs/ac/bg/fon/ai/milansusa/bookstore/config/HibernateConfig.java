package rs.ac.bg.fon.ai.milansusa.bookstore.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan(new String[] { "rs.ac.bg.fon.ai.milansusa.bookstore.model" });
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(Settings.getInstance().config.getDbConfig().getUrl());
		dataSource.setUsername(Settings.getInstance().config.getDbConfig().getUsername());
		dataSource.setPassword(Settings.getInstance().config.getDbConfig().getPassword());
		return dataSource;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.show_sql", String.valueOf(false));
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.connection.pool_size", String.valueOf(20));
		properties.setProperty("hibernate.connection.charSet", "UTF-8");
		properties.setProperty("hibernate.connection.characterEncoding", "UTF-8");
		properties.setProperty("hibernate.connection.useUnicode", String.valueOf(true));
		properties.setProperty("hibernate.connection.autocommit", String.valueOf(false));
		return properties;
	}

}
