package com.skdev9.eventflow.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateEventRequest(

        @NotBlank(message = "Event name is required")
        @Size(max = 50, message = "Event name must have at most 50 characters")
        String name,

        @NotBlank(message = "Description is required")
        @Size(max = 150, message = "Description must have at most 150 characters")
        String description,

        @NotBlank(message = "Location is required")
        @Size(max = 100, message = "Location must have at most 100 characters")
        String location,

        @NotNull(message = "Event date is required")
        @Future(message = "Event date must be in the future")
        LocalDateTime eventDate,

        @NotNull(message = "Total tickets is required")
        @Positive(message = "Total tickets must be greater than zero")
        Integer totalTickets,

        @NotNull(message = "Price is required")
        @PositiveOrZero(message = "Price must be zero or positive")
        @Digits(integer = 8, fraction = 2, message = "Price must have up to 8 digits and 2 decimal places")
        BigDecimal price

) {
}
