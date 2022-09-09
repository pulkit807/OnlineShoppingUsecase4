package com.usecase.onlineshopping.api.sos.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
//Class
public class SalesOrderApiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/orders/**").hasAnyRole("BASIC", "ADMIN").and().authorizeRequests()
				.antMatchers("/h2-console").permitAll().anyRequest().authenticated().and().formLogin().permitAll()
				.usernameParameter("username").and().httpBasic().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}
