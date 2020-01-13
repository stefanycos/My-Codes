package br.com.springboot.events.demo.event;

import org.springframework.context.ApplicationEvent;

import br.com.springboot.events.demo.models.Order;
import lombok.Getter;

@Getter
public class ChangeStatusEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private Order order; // NOSONAR

	public ChangeStatusEvent(Object source, Order order) {
		super(source);
		this.order = order;
	}

}
