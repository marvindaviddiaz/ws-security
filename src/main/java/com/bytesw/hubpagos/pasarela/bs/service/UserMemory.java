package com.bytesw.hubpagos.pasarela.bs.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserMemory implements UserDetails {
	
	private static final long serialVersionUID = 2895011034258559885L;
	
	private String username;
	private String password;
	private boolean enabled;
	
	public UserMemory() {
		super();
	}
	
	public UserMemory(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return enabled;
	}
	@Override
	public boolean isAccountNonLocked() {
		return enabled;
	}
	@Override
	public boolean isAccountNonExpired() {
		return enabled;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

}
