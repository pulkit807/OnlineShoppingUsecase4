package com.usecase.onlineshopping.api.items.security;

import java.util.List;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
//Class
public class ItemsApiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override

	protected void configure(HttpSecurity http) throws Exception {
		
		CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));

		http.csrf().disable().authorizeRequests().antMatchers("/items/**").hasAnyRole("BASIC", "ADMIN").anyRequest()
				.authenticated().and().formLogin().permitAll().usernameParameter("username").and().httpBasic().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
		http.cors().configurationSource(request -> corsConfiguration);
	}
}
