package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/", "/home", "/time").permitAll() //any request matching /, /home, /time can be accessed by anyone
		.anyRequest().authenticated() //any other request needs to be authenticated
		.and()
		.authorizeRequests().antMatchers("/admin/**") //only admin can access /admin/anything
		.hasRole("ADMIN")
		.and()
		.formLogin() // permit all to form login
		.permitAll()
		.and()
		.logout() //permit all to form logout
		.permitAll();
		
		
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.username("admin")
				.password("admin").build();
		
		return new InMemoryUserDetailsManager(user);
		
	}
}
