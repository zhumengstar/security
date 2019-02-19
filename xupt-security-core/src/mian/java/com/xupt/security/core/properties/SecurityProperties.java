package com.xupt.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="xupt.security")
public class SecurityProperties {
	private BrowserProperties browser=new BrowserProperties();
	
	public BrowserProperties getBrowserProperties() {
		return browser;
	}

	public void setBrowserProperties(BrowserProperties browser) {
		this.browser = browser;
	}
	
	
}
