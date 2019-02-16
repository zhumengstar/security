package com.xupt.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 可以拿到处理请求的http信息，也能拿到处理请求的方法信息，但是获取不到所传的参数
 * @author zgh
 *
 */ 
//@Component
public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle。。。。。。。");
		System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod) handler).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
		//返回为true才调用后面的方法
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("2.postHandle。。。。。。。");
		Long start=(Long)request.getAttribute("startTime");
		System.out.println("time interceptor 耗时："+(new Date().getTime()-start));
		
		

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterComletion。。。。。。");
		Long start=(Long)request.getAttribute("startTime");
		System.out.println("time interceptor 耗时："+(new Date().getTime()-start));
		System.out.println("ex is "+ex);

	}

}
