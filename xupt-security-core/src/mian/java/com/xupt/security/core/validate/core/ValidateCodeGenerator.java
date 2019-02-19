package com.xupt.security.core.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
	
	ImageCode gengerate(ServletWebRequest request);

}
