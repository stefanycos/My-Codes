package br.com.springboot.events.demo.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.springboot.events.demo.models.status.OrderStatus;
import lombok.Data;

@Data
@JsonInclude( value = Include.NON_NULL)
public class Order {

	private String id;

	private LocalDateTime createdAt;

	private LocalDateTime finishedAt;

	private OrderStatus status;

	private Double total;

	private List<Item> itens;
	
	public Order create(List<Item> itens) {
		this.status = OrderStatus.CREATED;
		this.itens = itens;
		this.createdAt = LocalDateTime.now();
		return this;
	}

	public void waitingPayment() {
		this.status = OrderStatus.WAITING_PAYMENT;
	}

	public void paid() {
		this.status = OrderStatus.PAID;
	}

	public void separing() {
		this.status = OrderStatus.SEPARING;
	}

	public void delivering() {
		this.status = OrderStatus.DELIVERING;
	}

	public void finished() {
		this.status = OrderStatus.FINISHED;
		this.finishedAt = LocalDateTime.now();
	}
	
}
