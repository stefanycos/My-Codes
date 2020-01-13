package br.com.springboot.events.demo.models.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.models.OrderFlow;

public class Create implements OrderFlow {

	private static final Logger logger = LoggerFactory.getLogger(Create.class);

	@Override
	public OrderStatus getNext() {
		return OrderStatus.WAITING_PAYMENT;
	}

	@Override
	public void execute(Order order) {
		order.create(order.getItens());
		logger.info("Order [{}] created succesfully!", order.getId());
	}

	@Override
	public void onError() {
		logger.error("An error occurred when trying create order");
	}

}
