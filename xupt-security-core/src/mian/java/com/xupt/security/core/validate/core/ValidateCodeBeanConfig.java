package com.xupt.security.core.validate.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xupt.security.core.properties.SecurityProperties;

@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	@ConditionalOnMissingBean()
	public ValidateCodeGenerator imaCodeGenerator() {
		ImageCodeGengertor codeGengertor = new ImageCodeGengertor();
		codeGengertor.setSecurityProperties(securityProperties);
		return codeGengertor;
	}

}
