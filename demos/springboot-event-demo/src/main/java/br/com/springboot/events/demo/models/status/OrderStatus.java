package br.com.springboot.events.demo.models.status;

import br.com.springboot.events.demo.models.OrderFlow;
import lombok.Getter;

@Getter
public enum OrderStatus {

	// @formatter:off
	
	CREATED(new Create()), 
	WAITING_PAYMENT(new WaitingPayment()), 
	PAID(new Paid()),
	SEPARING(new Separing()),
	DELIVERING(new Delivery()),
	FINISHED(new Finish());
	
	// @formatter:on

	private OrderFlow orderFlow;

	OrderStatus(OrderFlow orderFlow) { // NOSONAR
		this.orderFlow = orderFlow;
	}
	
	public OrderStatus getNext() {
		return this.orderFlow.getNext();
	}

}
