package com.pgssoft.mapper.docodereview.javaway.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rule implements Serializable {

    private static final long serialVersionUID = -7537409503723193287L;

    private List<RuleLine> lines = new ArrayList<>();

    public List<RuleLine> getLines() {
        return lines;
    }

    public void setLines(List<RuleLine> lines) {
        this.lines = lines;
    }
}
