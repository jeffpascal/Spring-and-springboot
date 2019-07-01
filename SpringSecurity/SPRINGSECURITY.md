## Spring security notes

- we want to secure the following endpoints
```java
package com.spring.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeSupplierEndpoint {

	@GetMapping(path = "/time", produces = "application/json")
	public LocalDate currentTime() {
		return LocalDate.MAX;
	}
	
	@GetMapping(path = "/userTime", produces = "application/json")
	public LocalDate lastTime() {
		return LocalDate.MIN;
	}
	
	@GetMapping(path = "/secretTime", produces = "application/json")
	public LocalDate secretCurrentTime() {
		return LocalDate.now();
	}
}
```
- we want to secure secretTime
- we want to leave /time available

```java
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/", "/home", "/time").permitAll() //any request matching /, /home, /time can be accessed by anyone
		.anyRequest().authenticated() //any other request needs to be authenticated
		.and()
		.authorizeRequests().antMatchers("/admin/**") //only admin can access /admin/anything
		.hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/login") // permit all to form login--- we use loginPage to use custom page
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
				.password("user")
				.roles("USER")
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user);
		
	}
```

- userDetailsService parameter 'user' is overrided by the admin login because it can only declare one with this way.

### Securing
- we allow all requests to /, /home, /time
``` java
.antMatchers("/", "/home", "/time").permitAll() //any request matching /, /home, /time can be accessed by anyone
```
- any other request needs to be authenticated:
```java
.anyRequest().authenticated() //any other request needs to be authenticated
```
- only ADMIN role can access /admin/anything
```java
.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN") //only admin can access /admin/anything
```
- we permit all access to the login page and declare a custom login screen using loginPage
```java
.formLogin().loginPage("/login").permitAll() // permit all to form login--- we use loginPage to use custom page
```

## html parameters
- we use param.error if there is an error
- we use param.logout to get confirmation of logout
```html
	<div th:if="${param.error}">
		Invalid username and password
	</div>
	<div th:if="${param.logout}">
		You have been logged out
	</div>
```

- old MVCConfig
```
package com.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
}
```

### Custom Authenticator classes


### Oauth2

- Understanding Oath2
- User issues authorization request
- Gets auth Grant
- Using auth grant we need to go authorization server to get the access token.
- We use the access token to get the protected Resource
- Every request needs to have that token in the request

### Most important Parameters
- clientId
- clientSecret - initizaliza process with the server
- accessTokenUri - uri that app uses to get/renew token
- userAuthorizationUri - URI where our client app needs to redirect user to make him perform actual authentication with third party that is providing oauth 2 token
- userInfoUri - URI that the client app can use to access additional info about user
