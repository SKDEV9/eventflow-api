package com.skdev9.eventflow.entity.enums;

public enum EventStatus {

    DRAFT("Draft"),
    PUBLISHED("Published"),
    SOLD_OUT("Sold out"),
    FINISHED("Finished"),
    CANCELLED("Cancelled");

    private final String description;

    EventStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
