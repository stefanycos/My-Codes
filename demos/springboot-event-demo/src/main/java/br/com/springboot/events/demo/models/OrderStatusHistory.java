package br.com.springboot.events.demo.models;

import java.time.LocalDateTime;

import br.com.springboot.events.demo.models.status.OrderStatus;
import lombok.Data;

@Data
public class OrderStatusHistory {

	private OrderStatus status;

	private Boolean isDelivered;

	private Integer attempts;

	private LocalDateTime deliveredDate;

	public void plusAttempt() {
		this.attempts++;
	}

}
