package br.com.springboot.events.demo.models.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.models.OrderFlow;

public class Finish implements OrderFlow {

	private static final Logger logger = LoggerFactory.getLogger(Finish.class);

	@Override
	public OrderStatus getNext() {
		return null;
	}

	@Override
	public void execute(Order order) {
		order.finished();
		logger.info("Order [{}] done and delivered succesffully!", order.getId());
	}

	@Override
	public void onError() {
		logger.error("An error occurred, executing rollback of order.");
	}
}
