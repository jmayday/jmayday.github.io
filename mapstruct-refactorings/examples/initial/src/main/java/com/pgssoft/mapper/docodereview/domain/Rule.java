package com.pgssoft.mapper.docodereview.domain;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    public List<RuleLine> getLines() {
        return lines;
    }

    private List<RuleLine> lines = new ArrayList<>();
}
