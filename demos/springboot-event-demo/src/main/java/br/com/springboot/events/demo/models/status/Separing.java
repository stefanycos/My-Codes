package br.com.springboot.events.demo.models.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.models.OrderFlow;

public class Separing implements OrderFlow {

	private static final Logger logger = LoggerFactory.getLogger(Separing.class);

	@Override
	public OrderStatus getNext() {
		return OrderStatus.DELIVERING;
	}

	@Override
	public void execute(Order order) {
		order.separing();
		logger.info("Order [{}] is being separated at stock", order.getId());
	}

	@Override
	public void onError() {
		logger.error("Products unavailable");
	}

}
