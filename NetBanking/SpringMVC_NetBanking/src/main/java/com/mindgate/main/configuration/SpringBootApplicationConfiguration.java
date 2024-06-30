package com.mindgate.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mindgate.main.repository.AccountDetailsRepository;
import com.mindgate.main.repository.CustomerDetailsRepository;
import com.mindgate.main.repository.CustomerDetailsRepositoryInterface;
import com.mindgate.main.repository.LogindetailsRepository;
import com.mindgate.main.service.AccountDetailService;
import com.mindgate.main.service.AccountDetailServiceInterface;
import com.mindgate.main.service.CustomerDetailsServiceInterface;
import com.mindgate.main.service.CustomerDetailsService;
import com.mindgate.main.service.LoginDetailsServiceImpl;

@Configuration
public class SpringBootApplicationConfiguration implements WebMvcConfigurer {
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String user="Project";
	private static final String password="training";
	

	
	
	@Bean
	public JdbcTemplate getJdbcTemplate()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driver);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(user);
		driverManagerDataSource.setPassword(password);
		
		return new JdbcTemplate(driverManagerDataSource);
	}

	@Bean

	ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}
	
//	@Bean
//	public CustomerDetailsRepository getcustomerDetailsRepositoryInterface()
//	{
//		return new CustomerDetailsRepository();
//	}
//	
//	@Bean
//	public CustomerDetailsServiceImpl getCustomerDetailsService()
//	{
//		return new CustomerDetailsServiceImpl();
//	}
//	
//	
//	@Bean
//	public LogindetailsRepositoryImpl logindetailsRepositoryImpl() {
//		return new LogindetailsRepositoryImpl();
//	}
//	
//	
//	@Bean
//	public LoginDetailsServiceImpl loginDetailsServiceImpl() {
//		return new LoginDetailsServiceImpl();
//	}
//	
//	@Bean
//	public AccountDetailsRepository getAccountDetailsRepository() {
//		return new AccountDetailsRepository();
//	}
//	
//	@Bean
//	public AccountDetailService getAccountDetailService()
//	{
//		return new AccountDetailService();
//	}
	
	
}
