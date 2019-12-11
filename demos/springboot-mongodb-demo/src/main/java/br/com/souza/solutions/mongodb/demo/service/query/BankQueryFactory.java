package br.com.souza.solutions.mongodb.demo.service.query;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.souza.solutions.mongodb.demo.filters.BankFilter;

@Component
public class BankQueryFactory {

	private static final String NAME = "name";

	public Query getQuery(BankFilter bankFilter) {
		Query query = new Query();

		addRegexCriteria(query, NAME, bankFilter.getName());
		addCriteriaOrderAndsort(query, bankFilter.getSortDirection(), bankFilter.getSortBy());
		return query;
	}

	private void addRegexCriteria(Query query, String key, String value) {
		if (!StringUtils.isEmpty(value)) {
			query.addCriteria(Criteria.where(key).regex(value, "i"));
		}
	}

	private void addCriteriaOrderAndsort(Query query, Direction sortDirection, String sortBy) {
		if (StringUtils.isEmpty(sortBy)) {
			return;
		}

		sortDirection = setDirection(sortDirection);

		query.with(Sort.by(sortDirection, sortBy));
	}

	private Direction setDirection(Direction sortDirection) {
		if (sortDirection == null) {
			sortDirection = Direction.ASC;
		}
		return sortDirection;
	}
}
