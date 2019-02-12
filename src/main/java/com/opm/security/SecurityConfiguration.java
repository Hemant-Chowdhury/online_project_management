package com.opm.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, 1 as enabled from user where username=?")
		.authoritiesByUsernameQuery("select  username,role from user where username=?");
	}   

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/login","/register","/guest/**").permitAll()
		.antMatchers("/user/**","/home").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
		.antMatchers("/**").access("hasRole('ROLE_ADMIN')")
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/home", true)
		.usernameParameter("username").passwordParameter("password")
		
		.and().csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/resources/**");
	}

//	@SuppressWarnings("deprecation")
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
}