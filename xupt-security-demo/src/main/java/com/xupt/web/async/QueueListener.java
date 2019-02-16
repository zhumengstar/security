package com.xupt.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MockQueue mockQueue;

	@Autowired
	private DeferredResultHolder defferredResultHolder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		logger.info("//////////////////");
		new Thread(() -> {
			while (true) {
				if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
					String orderNumber = mockQueue.getCompleteOrder();
					logger.info("返回订单处理结果：" + orderNumber);
					defferredResultHolder.getMap().get(orderNumber).setResult("place order success");
					mockQueue.setCompleteOrder(null);
				} else {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
