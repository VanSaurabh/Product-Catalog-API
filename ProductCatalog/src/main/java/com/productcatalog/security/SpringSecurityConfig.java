package com.productcatalog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String USER = "USER";
	private static final String ADMIN = "ADMIN";

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles(USER).and().withUser("admin")
				.password("password").roles(USER, ADMIN);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/v1/categories").hasAnyRole(USER, ADMIN)
				.antMatchers(HttpMethod.POST, "/v1/categories").hasRole(ADMIN)
				.antMatchers(HttpMethod.PUT, "/v1/categories/**").hasRole(ADMIN)
				.antMatchers(HttpMethod.DELETE, "/v1/categories/**").hasRole(ADMIN)
				.antMatchers(HttpMethod.GET, "/v1/products").hasAnyRole(USER, ADMIN)
				.antMatchers(HttpMethod.POST, "/v1/products").hasRole(ADMIN)
				.antMatchers(HttpMethod.PUT, "/v1/products/**").hasRole(ADMIN)
				.antMatchers(HttpMethod.DELETE, "/v1/products/**").hasRole(ADMIN).and().httpBasic().and().csrf()
				.disable().formLogin().disable().headers().frameOptions().disable();
	}
}
