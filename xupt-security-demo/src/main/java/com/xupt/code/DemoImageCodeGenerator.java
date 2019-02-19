package com.xupt.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.xupt.security.core.validate.core.ImageCode;
import com.xupt.security.core.validate.core.ValidateCodeGenerator;

//增量的方式适应变化
@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
	@Override
	public ImageCode gengerate(ServletWebRequest request) {
		// TODO Auto-generated method stub
		System.out.println("更高級的圖形驗證碼");	
		return null;
	}
}
