package com.xupt.security.browser;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xupt.security.browser.suport.SimpleResponse;
import com.xupt.security.core.properties.SecurityProperties;

@RestController
public class BrowserSecurityController {

	Logger logger = LoggerFactory.getLogger(getClass());
	// 跳转之前把当前的请求，存到session
	private RequestCache requestCache = new HttpSessionRequestCache();

	private RedirectStrategy redirctStrategy = new DefaultRedirectStrategy();

	@Autowired
	private SecurityProperties securityProperties;

	/**
	 * 当需要身份认证时，跳转到这里
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/authentication/require")
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest != null) {
			String targetUrl = savedRequest.getRedirectUrl();
			logger.info("引发跳转的请求是：" + targetUrl);
			logger.info("要跳转到:" + securityProperties.getBrowser().getLoginPage());
			if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
				redirctStrategy.sendRedirect(request, response,
						securityProperties.getBrowser().getLoginPage());
			}

		}
		return new SimpleResponse("访问的服务需要身份认证请引导用户到登录页");

	}

}
