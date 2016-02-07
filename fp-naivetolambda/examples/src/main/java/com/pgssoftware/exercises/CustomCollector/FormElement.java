/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises.CustomCollector;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kuba
 */
public class FormElement {

    private BigDecimal jobs;
    private BigDecimal maintenance;
    private BigDecimal service;

    public static class Builder {

        private BigDecimal jobs;
        private BigDecimal maintenance;
        private BigDecimal service;

        private Builder() {
        }

        public Builder jobs(final BigDecimal value) {
            this.jobs = value;
            return this;
        }

        public Builder maintenance(final BigDecimal value) {
            this.maintenance = value;
            return this;
        }

        public Builder service(final BigDecimal value) {
            this.service = value;
            return this;
        }

        public FormElement build() {
            return new com.pgssoftware.exercises.CustomCollector.FormElement(jobs, maintenance, service);
        }
    }

    public static FormElement.Builder builder() {
        return new FormElement.Builder();
    }

    public FormElement() {
    }
   
    public FormElement(final BigDecimal jobs, final BigDecimal maintenance, final BigDecimal service) {
        this.jobs = jobs;
        this.maintenance = maintenance;
        this.service = service;
    }    
    
    public BigDecimal getJobs() {
        return jobs;
    }

    public void setJobs(BigDecimal jobs) {
        this.jobs = jobs;
    }

    public BigDecimal getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(BigDecimal maintenance) {
        this.maintenance = maintenance;
    }

    public BigDecimal getService() {
        return service;
    }

    public void setService(BigDecimal service) {
        this.service = service;
    }

    @Override
    public String toString() {
        List<String> values = new ArrayList<String>();
        if (jobs != null) {
            values.add(String.format("jobs: %.2f", jobs.doubleValue()));
        }
        if (maintenance != null) {
            values.add(String.format("maintenance: %.2f", maintenance.doubleValue()));
        }
        if (service != null) {
            values.add(String.format("service: %.2f", service.doubleValue()));
        }
        return StringUtils.join(values, ", ");
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.jobs);
        hash = 29 * hash + Objects.hashCode(this.maintenance);
        hash = 29 * hash + Objects.hashCode(this.service);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormElement other = (FormElement) obj;
        if (!Objects.equals(this.jobs, other.jobs)) {
            return false;
        }
        if (!Objects.equals(this.maintenance, other.maintenance)) {
            return false;
        }
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        return true;
    }
    
    
    
    

}
