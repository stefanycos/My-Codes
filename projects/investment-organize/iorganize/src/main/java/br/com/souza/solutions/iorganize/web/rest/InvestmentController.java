package br.com.souza.solutions.iorganize.web.rest;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.iorganize.commons.Constants;
import br.com.souza.solutions.iorganize.models.Investment;
import br.com.souza.solutions.iorganize.service.BankService;
import br.com.souza.solutions.iorganize.service.GoalService;
import br.com.souza.solutions.iorganize.service.InvestmentService;
import br.com.souza.solutions.iorganize.service.InvestmentTypeService;
import br.com.souza.solutions.iorganize.utils.ObjectPropertyUtils;
import br.com.souza.solutions.iorganize.web.rest.dto.InvestmentDTO;
import br.com.souza.solutions.iorganize.web.rest.form.InvestmentForm;
import br.com.souza.solutions.iorganize.web.rest.mapper.InvestmentMapper;

@RestController
@RequestMapping("v1/api/investments")
public class InvestmentController {

	@Autowired
	private InvestmentService service;
	
	@Autowired
	private GoalService goalService;
	
	@Autowired
	private InvestmentTypeService investmentTypeService;
	
	@Autowired
	private BankService bankService;

	@Autowired
	private InvestmentMapper mapper;

	@GetMapping
	public Page<InvestmentDTO> get(@RequestParam(required = false) String status, Pageable pageable) {

		Page<Investment> investments = service.findAll(pageable, status);
		return mapper.toInvestmentDTO(investments);
	}

	@GetMapping("/{id}")
	public InvestmentDTO get(@PathVariable Long id) {

		Investment investment = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));
		return new InvestmentDTO(investment);
	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public InvestmentDTO save(@RequestBody @Valid InvestmentForm form) {
		Investment investment = form.converter(investmentTypeService, goalService, bankService);
		investment = service.save(investment);

		return new InvestmentDTO(investment);
	}

	@PutMapping("/{id}")
	@Transactional
	public InvestmentDTO update(@PathVariable Long id, @RequestBody InvestmentForm form) {

		Investment investment = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		ObjectPropertyUtils.copyNonNullProperties(form, investment);
		form.updateRelatedEntities(investment, investmentTypeService, goalService, bankService);
		
		return new InvestmentDTO(investment);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Transactional
	public void delete(@PathVariable Long id) {

		Investment investment = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		service.disable(investment);
	}

}
