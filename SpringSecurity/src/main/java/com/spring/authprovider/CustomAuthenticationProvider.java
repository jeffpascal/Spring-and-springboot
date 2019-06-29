package com.spring.authprovider;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private ThirdPartyAuthProviderClient thirdPartyAuthProviderClient;
	
	// one a user logs in, the authentication variable is filled with the details of the authentication
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// when the user logs in to the application, our object will be filled by spring
		String name = authentication.getName();
		Object password = authentication.getCredentials(); //object that encapsulates password that user types 
		// not printing or storing password anyone
		
		if(thirdPartyAuthProviderClient.shouldAuthenticate(name,password)) {
			// the array list is for roles, because we are not using it now, we are sending it an empty one
			return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
		} else {
			System.out.println("authentication failed for user: " + name);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// there are multiple ways of authentication, use use username and password
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
