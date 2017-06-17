package com.pgssoft.mapper.docodereview.afterreview.mapper;

import com.pgssoft.mapper.docodereview.domain.RuleExpression;
import com.pgssoft.mapper.docodereview.domain.Rule;
import org.mapstruct.Mapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper
public interface RuleMapperRevisited {

    default List<String> toExpressionStrings(List<Rule> dependencyRules) {
        return dependencyRules.stream()
                .flatMap(rule -> rule.getLines().stream())
                .map(RuleExpression::of)
                .map(RuleExpression::toString)
                .collect(toList());
    }

}
