package br.com.springboot.events.demo.models.status;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.models.OrderFlow;

public class Delivery implements OrderFlow {

	private static final Logger logger = LoggerFactory.getLogger(Delivery.class);

	@Override
	public OrderStatus getNext() {
		return OrderStatus.FINISHED;
	}

	@Override
	public void execute(Order order) {
		order.delivering();
		logger.info("Order [{}] is out for delivery and will arrive until [{}]", order.getId(), getDueDate());
	}

	@Override
	public void onError() {
		logger.error("The order couldn't be delivery within 3 attempts");
	}

	private LocalDateTime getDueDate() {
		return LocalDateTime.now().plusDays(5);
	}
}
