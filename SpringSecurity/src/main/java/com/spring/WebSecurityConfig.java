package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.spring.authprovider.CustomAuthenticationProvider;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home", "/time").permitAll() // any request matching /, /home, /time
																				// can be accessed by anyone
				.anyRequest().authenticated() // any other request needs to be authenticated
				.and().authorizeRequests().antMatchers("/admin/**") // only admin can access /admin/anything
				.hasRole("ADMIN")
				.and().formLogin().loginPage("/login") // permit all to form login--- we use loginPage to use custom page
				.permitAll()
				.and().logout() // permit all to form logout
				.permitAll();

	}
// get rid of this mechanism because it conflicts with the one below
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER")
//				.username("admin").password("admin").roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user);
//
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//specify auth provider
		auth.authenticationProvider(authProvider);
	}

	// configuration of static resources
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/templates/**", "/assets/**");
	}
}
