package com.xupt.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.xupt.security.browser.authentication.XuptAuthenticationFailureHandler;
import com.xupt.security.browser.authentication.XuptAuthenticationSuccessHandler;
import com.xupt.security.core.properties.SecurityProperties;
import com.xupt.security.core.validate.core.ValidateCodeFilter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired XuptAuthenticationSuccessHandler xuptAuthenticationSuccessHandler;
	@Autowired XuptAuthenticationFailureHandler xuptAuthenticationFailureHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//自定义filter，放在UsernamePasswordAuthenticationFilter之前
		ValidateCodeFilter validateCodeFilter=new ValidateCodeFilter();
		validateCodeFilter.setAuthenticationFailureHandler(xuptAuthenticationFailureHandler);
		
		// TODO Auto-generated method stub
//		super.configure(http);
		System.out.println(securityProperties.getBrowserProperties().getLoginPage());
		http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
				.formLogin().loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
				.successHandler(xuptAuthenticationSuccessHandler)
				.failureHandler(xuptAuthenticationFailureHandler)
//		http.httpBasic()
				.and().authorizeRequests().antMatchers("/authentication/require",securityProperties.getBrowserProperties().getLoginPage(),"/code/image").permitAll()
				.anyRequest().authenticated()
				.and().csrf().disable();
	}

}







