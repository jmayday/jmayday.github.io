/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.CustomCollector;

import java.math.BigDecimal;
import java.util.AbstractMap;
import org.apache.commons.lang3.ObjectUtils;

/**
 *
 * @author kuba
 */
public class ElementCombiner {

    private FormElement element;

    public FormElement getElement() {
        return element;
    }

    public ElementCombiner() {
        this.element = new FormElement();
    }

    public ElementCombiner add(AbstractMap.SimpleEntry<Type, AbstractMap.SimpleEntry<Integer, BigDecimal>> element) {
        switch (element.getKey()) {
            case JOBS:
                this.element.setJobs(element.getValue().getValue());
                break;
            case MAINTENANCE:
                this.element.setMaintenance(element.getValue().getValue());
                break;
            case SERVICE:
                this.element.setService(element.getValue().getValue());
                break;
            default:
                throw new RuntimeException("unknown element type " + element.getKey());
        }
        return this;

    }

    public ElementCombiner merge(ElementCombiner combiner) {
        this.element.setJobs(ObjectUtils.firstNonNull(this.element.getJobs(), combiner.element.getJobs()));
        this.element.setMaintenance(ObjectUtils.firstNonNull(this.element.getMaintenance(), combiner.element.getMaintenance()));
        this.element.setService(ObjectUtils.firstNonNull(this.element.getService(), combiner.element.getService()));
        return this;
    }
}
