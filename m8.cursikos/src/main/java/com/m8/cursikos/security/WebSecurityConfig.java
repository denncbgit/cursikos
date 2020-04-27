package com.m8.cursikos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//eximir a este tipo de archivos para la seguridad
	String [] archivosValidos =  new String[]{ "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/layer/**", "/templates/**"
			, "/html/**", "/webjars/**", "/h2-console/**", "/jsp/**"};
		
		@Autowired
		UserDetailsServiceImpl userDetailsService;
		
		@Bean
		public BCryptPasswordEncoder passwordEncode() {
			return new BCryptPasswordEncoder();
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncode());
		}
	 	@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        	//Con este primer parametro indicamos que en las siguientes lineas configuraremos las request
	            .authorizeRequests()
	            //permitimos acceder a los archivos a todos
		        .antMatchers(archivosValidos ).permitAll()
		        .antMatchers("/","/usuario/*").permitAll()//Marcamos las Url a las que se puede entrar sin registro
		        .antMatchers("/admin*").access("hasRole('ADMIN')")//Marcamos que dentro de las rutras que empiece por admin solo podra entrar admin
		        .antMatchers("/usuario*", "/usuario/login").access("hasRole('USER') or hasRole('ADMIN')")//lo mismo pero para usuario correitne y admin
	                .anyRequest().authenticated()//Lo que no se contemple en las propiedades anteriores seran redirigidos a la pagina de login
	                .and()
	            .formLogin()
	                //.loginPage("/login")
	                .permitAll()
	                .defaultSuccessUrl("/")
	                .failureUrl("/error?error=true")
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .and()
	                .csrf().ignoringAntMatchers("/h2-console/**")
            		.and()
            		.headers().frameOptions().sameOrigin()
	        		.and()
//					.defaultSuccessUrl("/", true)
//					.loginProcessingUrl("/auth/login-post")
//					.permitAll()
//					.and()
	            .logout()
	                .permitAll()
	                .logoutSuccessUrl("/");
            		
	        
	    }
}
