package br.com.souza.solutions.iorganize.web.rest.form;

import static br.com.souza.solutions.iorganize.utils.Utils.getDateFromString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.souza.solutions.iorganize.models.Investment;
import br.com.souza.solutions.iorganize.service.BankService;
import br.com.souza.solutions.iorganize.service.GoalService;
import br.com.souza.solutions.iorganize.service.InvestmentTypeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentForm {

	@NotEmpty
	@NotNull
	private String investmentTypeName;

	@NotEmpty
	@NotNull
	private String goalName;

	@NotEmpty
	@NotNull
	private String bankName;

	@NotNull
	private BigDecimal value;

	@NotNull
	private String dueDate;
	
	private String initialDate;
	
	private String description;
	
	@NotNull
	private BigDecimal price;
	
	@NotNull
	private Double profitability;

	private Boolean status;
	
	public Investment converter(InvestmentTypeService investmentTypeService, GoalService goalService, BankService bankService) {
		
		return Investment.builder()
				.investmentType(investmentTypeService.findByName(investmentTypeName))
				.goal(goalService.findByName(goalName))
				.bank(bankService.findByName(bankName))
				.value(value)
				.dueDate(getDateFromString(dueDate))
				.initialDate(initialDate != null ? getDateFromString(initialDate) : LocalDateTime.now())
				.description(description)
				.price(price)
				.profitability(profitability)
				.status(true).build();
				
	}
	
	public void updateRelatedEntities(Investment investment, InvestmentTypeService investmentTypeService, GoalService goalService, BankService bankService) {
		if (investmentTypeName != null) {
			investment.setInvestmentType(investmentTypeService.findByName(investmentTypeName));
		}

		if (goalName != null) {
			investment.setGoal(goalService.findByName(goalName));
		}

		if (bankName != null) {
			investment.setBank(bankService.findByName(bankName));
		}
	}

}
