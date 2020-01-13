package br.com.springboot.events.demo.models.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.models.OrderFlow;

public class Paid implements OrderFlow {

	private static final Logger logger = LoggerFactory.getLogger(Paid.class);

	@Override
	public OrderStatus getNext() {
		return OrderStatus.SEPARING;
	}

	@Override
	public void execute(Order order) {
		order.paid();
		logger.info("payment approved Order [{}]", order.getId());
	}

	@Override
	public void onError() {
		logger.error("Products unavailable");
	}

}
