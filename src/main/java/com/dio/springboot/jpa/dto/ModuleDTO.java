package com.dio.springboot.jpa.dto;

import java.time.ZonedDateTime;

public class ModuleDTO {

    private long id;

    private boolean freeAdmission;

    private boolean dailyAdmission;

    private Double price;

    private ZonedDateTime vencimentDate;

    public ModuleDTO(){}

    public ModuleDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFreeAdmission() {
        return freeAdmission;
    }

    public void setFreeAdmission(boolean freeAdmission) {
        this.freeAdmission = freeAdmission;
    }

    public boolean isDailyAdmission() {
        return dailyAdmission;
    }

    public void setDailyAdmission(boolean dailyAdmission) {
        this.dailyAdmission = dailyAdmission;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ZonedDateTime getVencimentDate() {
        return vencimentDate;
    }

    public void setVencimentDate(ZonedDateTime vencimentDate) {
        this.vencimentDate = vencimentDate;
    }
}
