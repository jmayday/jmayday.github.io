/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware.exercises;

import java.math.BigDecimal;

/**
 *
 * @author kuba
 */
public class Element {

    private BigDecimal jobs;

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
    private BigDecimal maintenance;
    private BigDecimal service;

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return String.format("jobs: %f, maintenance: %f, service: %f", getJobs(), getMaintenance(), getService());
    }
    
    

}
