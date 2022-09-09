package com.usecase.onlineshopping.api.customer.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
//Class
public class CustomerApiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override

	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/customer").hasAnyRole("BASIC", "ADMIN").antMatchers("/customers")
				.hasAnyRole("BASIC", "ADMIN").antMatchers("/status/check").permitAll().anyRequest().authenticated()
				.and().formLogin().permitAll().usernameParameter("username").and()
		         .httpBasic().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
	}
}
