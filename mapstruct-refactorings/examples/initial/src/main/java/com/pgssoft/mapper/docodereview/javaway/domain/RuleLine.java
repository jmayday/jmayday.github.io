package com.pgssoft.mapper.docodereview.javaway.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RuleLine implements Serializable {

    private static final long serialVersionUID = -7537409503723193287L;

    private List<RuleValue> values = new ArrayList<>();


    public List<RuleValue> getValues() {
        return values;
    }


}
