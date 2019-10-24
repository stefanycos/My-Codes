package br.com.souza.solutions.iorganize.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	private InvestmentType investmentType;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	private Goal goal;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	private Bank bank;

	@Column(nullable = false)
	private BigDecimal value;

	@Column(nullable = false)
	private LocalDateTime initialDate;

	@Column(nullable = false)
	private LocalDateTime dueDate;

	@Column(length = 100, nullable = true)
	private String description;

	@Column(nullable = true)
	private BigDecimal price;

	@Column(nullable = false)
	private Double profitability;

	@Column(nullable = false)
	private Boolean status;

}
