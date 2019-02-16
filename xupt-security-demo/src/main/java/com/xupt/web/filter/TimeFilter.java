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

/**
 * 可你拿到原始的http请求和响应信息，缺点是拿不到处理请求方法的信息
 * @author zgh
 *
 */
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
		System.out.println("1.time filter start");
		long start=new Date().getTime();
		chain.doFilter(request, response);
		System.out.println(chain.getClass());
		System.out.println("time filter耗时："+(new Date().getTime()-start));
		System.out.println("time filter finish");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("time filter destroy");

	}

}
