package com.pgssoft.mapper.docodereview.beforereview.mapper;

import com.pgssoft.mapper.docodereview.domain.RuleExpression;
import com.pgssoft.mapper.docodereview.domain.Rule;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper
public interface RuleMapper {

    default List<String> toExpressionStrings(List<Rule> dependencyRules) {
        return dependencyRules.stream()
                .map(rule -> rule.getLines().stream()
                        .map(line -> {
                            RuleExpression expression = new RuleExpression();
                            line.getValues().forEach(
                                    value -> expression.add(value.getParameter().getId().toString(), value.getId().toString())
                            );
                            return expression.toString();
                        }).collect(toList())
                )
                .flatMap(Collection::stream)
                .collect(toList());
    }

}
