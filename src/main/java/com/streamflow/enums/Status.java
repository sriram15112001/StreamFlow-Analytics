package com.streamflow.enums;

public enum Status {
    COMPLETED("COMPLETED"),
    PENDING("PENDING"),
    REFUNDED("REFUNDED");

    private final String statusName;

    Status(String status) {
        this.statusName = status;
    }

    public String getStatus() {
        return this.statusName;
    }

}
