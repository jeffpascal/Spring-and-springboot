package com.spring.authprovider;

import org.springframework.stereotype.Component;

@Component
public class ThirdPartyAuthProviderClient {

	//emulates request to third party application
	public boolean shouldAuthenticate(String username, Object password) {
		// 3rd party request to see if user is correct or no or should be logged in
		// user with username with 4 digits can be logged in to the application
		return username.length() == 4;
	}

}
