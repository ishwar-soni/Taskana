package com.upgrad.taskana.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("ishwar")
//					.password("{noop}soni")
//					.authorities("ROLE_USER")
//				.and()
//				.withUser("parth")
//					.password("{noop}aksh")
//					.authorities("ROLE_USER");
		
		auth
			.jdbcAuthentication()
				.dataSource(datasource)
				.usersByUsernameQuery(
						"SELECT username, password, enabled FROM USERS WHERE username = ?")
				.authoritiesByUsernameQuery(
						"SELECT username, authority FROM USER_AUTHORITIES WHERE username = ?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}
