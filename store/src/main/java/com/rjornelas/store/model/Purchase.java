package com.rjornelas.store.model;

public class Purchase {

    private Long orderId;

    private Integer preparationTime;

    private String destinyAdress;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getDestinyAdress() {
        return destinyAdress;
    }

    public void setDestinyAdress(String destinyAdress) {
        this.destinyAdress = destinyAdress;
    }
}
