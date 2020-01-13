package br.com.springboot.events.demo.models;

import br.com.springboot.events.demo.models.status.OrderStatus;

public interface OrderFlow {
	
	public OrderStatus getNext();
	
	public void execute(Order order);
	
	public void onError();

}
