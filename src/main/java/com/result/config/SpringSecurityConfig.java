package com.result.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.result.authenticationprovider.CustomAuthenticationProvider;

@EnableWebSecurity

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationProvider customAuthProvider;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthProvider);
		auth.inMemoryAuthentication().withUser("Nithya").password("{noop}nithya@123").roles("ADMIN").and()
				.withUser("Sathya").password("{noop}sathya@123").roles("STUDENT");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors();
		http.csrf().disable();
		http.httpBasic().and().authorizeRequests().antMatchers("/admin**").authenticated();

	}

}
