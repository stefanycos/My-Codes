package br.com.springboot.events.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import br.com.springboot.events.demo.event.ChangeStatusEvent;
import br.com.springboot.events.demo.models.Item;
import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.models.status.OrderStatus;

@Service
public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	private Map<String, Order> orders = new HashMap<>();

	public OrderService() {
		createInitialItens();
	}

	public Order create() {
		Order order = new Order().create(getItens(3));
		order.setId("57dd69b536c874e39acc1838a");
		order.setTotal(getTotal(order));

		orders.put(order.getId(), order);
		return order;
	}

	public void changeStatus(Order order) {
		ChangeStatusEvent event = new ChangeStatusEvent(this, order);
		OrderStatus next = order.getStatus().getNext();

		if (next == null) {
			order.getStatus().getOrderFlow().execute(order);
			return;
		}

		next.getOrderFlow().execute(order);
		logger.info("Changing order status");
		applicationEventPublisher.publishEvent(event);
	}

	public List<Order> findAll() { // @formatter:off
		return orders.values()
				.stream()
				.collect(Collectors.toList()); // @formatter:on
	}

	public Optional<Order> findById(String id) {
		Order order = orders.get(id);
		if (order != null) {
			return Optional.of(order);
		}

		return Optional.empty();
	}

	private void createInitialItens() {
		Order order1 = new Order().create(getItens(1));
		order1.setId("5dd69b536c874e39ack1838a");
		order1.setTotal(getTotal(order1));

		Order order2 = new Order().create(getItens(2));
		order2.setId("6dd69b536c874e39ack1825a");
		order2.setTotal(getTotal(order2));

		orders.put(order1.getId(), order1);
		orders.put(order2.getId(), order2);
	}

	private List<Item> getItens(int quantity) {
		Item item1 = new Item(ProductService.getGameProduct(), quantity);
		Item item2 = new Item(ProductService.getNotebookProduct(), quantity + 2);

		return Arrays.asList(item1, item2);
	}

	private double getTotal(Order order) {
		return order.getItens().stream().mapToDouble(o -> o.getProduct().getValue()).sum();
	}

}
