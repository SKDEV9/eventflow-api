package com.skdev9.eventflow.service;

import com.skdev9.eventflow.dto.request.CreateEventRequest;
import com.skdev9.eventflow.dto.response.EventResponse;
import com.skdev9.eventflow.entity.Event;
import com.skdev9.eventflow.entity.enums.EventStatus;
import com.skdev9.eventflow.mapper.EventMapper;
import com.skdev9.eventflow.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventResponse createEvent(CreateEventRequest request) {

        Event event = eventMapper.toEntity(request);

        event.setAvailableTickets(event.getTotalTickets());
        event.setStatus(EventStatus.DRAFT);

        Event savedEvent = eventRepository.save(event);

        return eventMapper.toResponse(savedEvent);
    }

    public EventResponse findEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        return eventMapper.toResponse(event);
    }

    public List<EventResponse> findAllEvents() {
        List<Event> events = eventRepository.findAll();

        return eventMapper.toResponseDtoList(events);
    }
}
