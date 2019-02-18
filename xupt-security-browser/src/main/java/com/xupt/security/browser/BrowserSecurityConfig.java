package com.xupt.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.xupt.security.core.properties.SecurityProperties;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		System.out.println(securityProperties.getBrowserProperties().getLoginPage());
		http.formLogin().loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
//		http.httpBasic()
				.and().authorizeRequests().antMatchers("/authentication/require",securityProperties.getBrowserProperties().getLoginPage()).permitAll()
				.anyRequest().authenticated()
				.and().csrf().disable();
	}

}
