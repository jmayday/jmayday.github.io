package com.pgssoft.mapper.docodereview.javaway.domain;

import java.io.Serializable;

public class RuleValue implements Serializable {

    private static final long serialVersionUID = -7537409503723193287L;

    private Long id;

    private Parameter parameter;

    private RuleLine line;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public RuleLine getLine() {
        return line;
    }

    public void setLine(RuleLine line) {
        this.line = line;
    }
}
