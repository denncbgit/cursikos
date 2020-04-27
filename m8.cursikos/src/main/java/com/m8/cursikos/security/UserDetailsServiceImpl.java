package com.m8.cursikos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.m8.cursikos.entities.Usuario;
import com.m8.cursikos.repositorios.UsuarioRepositorio;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UsuarioRepositorio repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findByUsername(username);
		
		UserBuilder builder = null;
		
		if (usuario != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getEncPassword());
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return builder.build();
	}
}
