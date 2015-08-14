package com.bytesw.hubpagos.pasarela.bs.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if ("mdiaz".equals(username)) {
			return new UserMemory(username, "d033e22ae348aeb5660fc2140aec35850c4da997", true);
		}

		throw new UsernameNotFoundException("Username not found: " + username);
	}

}
