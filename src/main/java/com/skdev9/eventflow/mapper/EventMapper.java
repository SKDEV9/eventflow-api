package com.skdev9.eventflow.mapper;

import com.skdev9.eventflow.dto.request.CreateEventRequest;
import com.skdev9.eventflow.dto.response.EventResponse;
import com.skdev9.eventflow.entity.Event;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMapper {

    public Event toEntity(CreateEventRequest request) {
        if (request == null) {
            return null;
        }

        Event event = new Event();

        event.setName(request.name());
        event.setDescription(request.description());
        event.setLocation(request.location());
        event.setEventDate(request.eventDate());
        event.setTotalTickets(request.totalTickets());
        event.setPrice(request.price());

        return event;
    }

    public EventResponse toResponse(Event event) {
        if (event == null) {
            return null;
        }

        return new EventResponse(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getLocation(),
                event.getEventDate(),
                event.getTotalTickets(),
                event.getAvailableTickets(),
                event.getPrice(),
                event.getStatus(),
                event.getCreatedAt(),
                event.getUpdatedAt()
        );
    }

    public List<EventResponse> toResponseDtoList(List<Event> events) {
        if (events == null) {
            return List.of();
        }

        return events.stream()
                .map(this::toResponse)
                .toList();
    }
}
