package com.xupt.security.core.properties;

public class BrowserProperties {
	
	private String loginPage="/xupt-signIn.html";
	
	private LoginResponseType loginType=LoginResponseType.JSON;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
		this.loginType = loginType;
	}	
	
}
