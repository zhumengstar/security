package com.xupt.web.controller;

import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class AsyncController {
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/order")
	public Callable<String> order() throws Exception {
		logger.info("主线程开始");
		Callable<String> result=new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				logger.info("副线程开始");
				Thread.sleep(1000);
				logger.info("副线程返回");

				return "Success";
			}
		};
		logger.info("主线程返回");
		return result;
	}

}
