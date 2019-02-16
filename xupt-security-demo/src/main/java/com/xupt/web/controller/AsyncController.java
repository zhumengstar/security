package com.xupt.web.controller;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.xupt.web.async.DeferredResultHolder;
import com.xupt.web.async.MockQueue;


@RestController
@RequestMapping
public class AsyncController {
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MockQueue mockQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolader;
	
	@RequestMapping(value="/order")
	public DeferredResult<String> order() throws Exception {
		logger.info("主线程开始");
		String orderNumber=RandomStringUtils.randomNumeric(8);

		mockQueue.setPlaceOrder(orderNumber);
		DeferredResult<String> result=new DeferredResult<>();
		deferredResultHolader.getMap().put(orderNumber,result);
//		Callable<String> result=new Callable<String>() {
//
//			@Override
//			public String call() throws Exception {
//				// TODO Auto-generated method stub
//				logger.info("副线程开始");
//				Thread.sleep(1000);
//				logger.info("副线程返回");
//
//				return "Success";
//			}
//		};
		logger.info("主线程返回");
		return result;
	}

}
