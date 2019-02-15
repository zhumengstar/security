package com.xupt.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("time filter init");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("time filter start");
		long start=new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("time filter耗时："+(new Date().getTime()-start));
		System.out.println("time filter finish");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("time filter destroy");

	}

}
