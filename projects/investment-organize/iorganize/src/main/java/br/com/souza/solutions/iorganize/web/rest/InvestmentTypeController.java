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
import br.com.souza.solutions.iorganize.models.InvestmentType;
import br.com.souza.solutions.iorganize.service.InvestmentTypeService;
import br.com.souza.solutions.iorganize.utils.ObjectPropertyUtils;
import br.com.souza.solutions.iorganize.web.rest.dto.InvestmentTypeDTO;
import br.com.souza.solutions.iorganize.web.rest.form.InvestmentTypeForm;
import br.com.souza.solutions.iorganize.web.rest.mapper.InvestmentTypeMapper;

@RestController
@RequestMapping("v1/api/investment/type")
public class InvestmentTypeController {

	@Autowired
	private InvestmentTypeService service;

	@Autowired
	private InvestmentTypeMapper mapper;

	@GetMapping
	public Page<InvestmentTypeDTO> get(@RequestParam(required = false) String status, Pageable pageable) {

		Page<InvestmentType> types = service.findAll(pageable, status);
		return mapper.toInvestmentTypeDTO(types);
	}

	@GetMapping("/{id}")
	public InvestmentTypeDTO get(@PathVariable Long id) {

		InvestmentType type = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));
		return new InvestmentTypeDTO(type);
	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public InvestmentTypeDTO save(@RequestBody @Valid InvestmentTypeForm form) {
		InvestmentType type = form.converter();
		type = service.save(type);

		return new InvestmentTypeDTO(type);
	}

	@PutMapping("/{id}")
	@Transactional
	public InvestmentTypeDTO update(@PathVariable Long id, @RequestBody InvestmentTypeForm form) {

		InvestmentType type = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		ObjectPropertyUtils.copyNonNullProperties(form, type);

		return new InvestmentTypeDTO(type);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Transactional
	public void delete(@PathVariable Long id) {

		InvestmentType type = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		service.disable(type);
	}

}
