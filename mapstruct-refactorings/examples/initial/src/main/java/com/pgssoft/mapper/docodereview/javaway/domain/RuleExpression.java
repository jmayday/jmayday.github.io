package com.pgssoft.mapper.docodereview.javaway.domain;

public class RuleExpression {

    public static RuleExpression of(RuleLine line) {

        RuleExpression expression = new RuleExpression();

        line.getValues().forEach(
                value -> expression.add(
                        value.getParameter().getId().toString(),
                        value.getId().toString())
        );

        return expression;
    }

    public void add(String key, String value) {
    }

}
