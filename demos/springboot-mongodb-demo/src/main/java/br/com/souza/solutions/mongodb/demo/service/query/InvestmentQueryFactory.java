package br.com.souza.solutions.mongodb.demo.service.query;

import static br.com.souza.solutions.mongodb.demo.utils.DateFormatterUtils.getDateWithMaxTime;
import static br.com.souza.solutions.mongodb.demo.utils.DateFormatterUtils.getDateWithMinTime;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.souza.solutions.mongodb.demo.filters.InvestmentFilter;

@Component
public class InvestmentQueryFactory {

	private static final String GOAL = "goal.$id";
	private static final String ACCOUNT = "account.$id";
	private static final String TYPE = "investmentType.$id";
	private static final String DUE_DATE = "dueDate";

	public Query getQuery(InvestmentFilter filters) {
		Query query = new Query();

		addObjectIdCriteria(query, GOAL, filters.getGoal().getId());
		addObjectIdCriteria(query, ACCOUNT, filters.getAccount().getId());
		addObjectIdCriteria(query, TYPE, filters.getType().getId());
		addDateCriteria(query, DUE_DATE, filters.getDueDate(), filters.getDueDate());

		return query;
	}

	private void addObjectIdCriteria(Query query, String key, String value) {
		if (!StringUtils.isEmpty(value)) {
			query.addCriteria(Criteria.where(key).is(new ObjectId(value)));
		}
	}

	public void addCriteria(Query query, String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			query.addCriteria(Criteria.where(key).is(value));
		}
	}

	private void addDateCriteria(Query query, String key, LocalDateTime afterAt, LocalDateTime beforeAt) {
		if (!StringUtils.isEmpty(afterAt) && !StringUtils.isEmpty(beforeAt)) {

			afterAt = getDateWithMinTime(afterAt);
			beforeAt = getDateWithMaxTime(beforeAt);

			Criteria criteria = new Criteria();

			criteria.andOperator( // @formatter:off
					Criteria.where(key).gte(afterAt), 
					Criteria.where(key).lte(beforeAt)); // @formatter:on

			query.addCriteria(criteria);
		}
	}

}
