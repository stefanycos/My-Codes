package br.com.springboot.events.demo.models.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.models.OrderFlow;

public class WaitingPayment implements OrderFlow {

	private static final Logger logger = LoggerFactory.getLogger(WaitingPayment.class);

	@Override
	public OrderStatus getNext() {
		return OrderStatus.PAID;
	}

	@Override
	public void execute(Order order) {
		order.waitingPayment();
		logger.info("Order [{}] is wating for payment be confirmed", order.getId());
	}

	@Override
	public void onError() {
		logger.error("Payment not processed");
	}

}
