package com.bank.abc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("ravi").password("ravi")
		 * .roles("USER", "ADMIN");
		 */
		auth.inMemoryAuthentication().withUser("admin").password("admin")
		 .roles( "ADMIN");
		
		  auth.inMemoryAuthentication().withUser("user").password("user") .roles(
		  "USER");
		 
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/", "/*customer*/**").access("hasAnyRole('ADMIN','USER')").and()
                .formLogin();
        //http.csrf().disable();
    }
}
