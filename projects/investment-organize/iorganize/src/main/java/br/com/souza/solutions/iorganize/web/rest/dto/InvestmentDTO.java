package br.com.souza.solutions.iorganize.web.rest.dto;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusDescription;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.souza.solutions.iorganize.models.Investment;
import lombok.Data;

@Data
public class InvestmentDTO {

	private Long id;

	private String investmentType;

	private String goal;

	private String bank;

	private BigDecimal value;

	private LocalDateTime dueDate;

	private BigDecimal price;

	private Double profitability;

	private String status;

	public InvestmentDTO(Investment investment) {
		this.id = investment.getId();
		this.investmentType = investment.getInvestmentType().getName();
		this.goal = investment.getGoal().getName();
		this.bank = investment.getBank().getName();
		this.value = investment.getValue();
		this.dueDate = investment.getDueDate();
		this.price = investment.getPrice();
		this.profitability = investment.getProfitability();
		this.status = getStatusDescription(investment.getStatus());
	}

}
