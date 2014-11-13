package com.sprhib.init;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService customUserDetailsService;

	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.userDetailsService(customUserDetailsService).authorizeRequests()
				.antMatchers("/team").hasAnyRole("MODERATOR, ADMIN")
				.antMatchers("/team/**").hasAnyRole("MODERATOR,ADMIN")
				.antMatchers("/user").hasRole("ADMIN")
				.antMatchers("/user/**").hasRole("ADMIN").and()
				.formLogin().loginProcessingUrl("/j_spring_security_check")
				.loginPage("/login").failureUrl("/login?error").and()
				.formLogin().defaultSuccessUrl("/team").and().logout()
				.invalidateHttpSession(true)
				.logoutUrl("/j_spring_security_logout")
				.logoutSuccessUrl("/login?logout").and().exceptionHandling()
				.accessDeniedPage("/403").and().csrf().disable();
	}
}
