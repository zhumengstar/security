package com.xupt.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.xupt.service.HelloService;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object>{
	
	@Autowired
	private HelloService helloService;

	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		System.out.println("my validator init");
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		helloService.greeting("tom");
		System.out.println(value);
		
		return false;
	}

}
