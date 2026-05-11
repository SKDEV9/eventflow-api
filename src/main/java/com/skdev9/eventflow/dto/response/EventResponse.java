package com.skdev9.eventflow.dto.response;

import com.skdev9.eventflow.entity.enums.EventStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public record EventResponse(

        Long id,

        String name,

        String description,

        String location,

        LocalDateTime eventDate,

        Integer totalTickets,

        Integer availableTickets,

        BigDecimal price,

        EventStatus status,

        Instant createdAt,

        Instant updatedAt


) {

}
