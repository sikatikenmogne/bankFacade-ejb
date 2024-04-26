package com.bank.paymentmgmt.model;

import java.io.Serializable;

public class Payment implements Serializable {

    private Long id;

    private PaymentStatus status;

    private String ccNumber;
    private Double amount;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public PaymentStatus getStatus() {
        return status;
    }
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
    public String getCcNumber() {
        return ccNumber;
    }
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "business.domain.Payment[id="+id+" ccNumber=" + ccNumber + " Amount="+
                amount+"]";
    }
}
