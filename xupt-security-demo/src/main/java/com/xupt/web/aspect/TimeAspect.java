package com.xupt.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切片可以获取到方法真正调用传的参数，获取不到原始Http请求和响应的对象
 * @author zgh
 *
 */
@Aspect
@Component
public class TimeAspect {
	@Around("execution(* com.xupt.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("3.time aspect start");
		
		Object[] args=pjp.getArgs();
		for (Object arg : args) {
			System.out.println("arg is "+arg);
		}

		long start = new Date().getTime();
		Object object = pjp.proceed();
		System.out.println("time aspect 耗时：" + (new Date().getTime() - start));

		System.out.println("time aspect finish");
		return object;
	}
}
