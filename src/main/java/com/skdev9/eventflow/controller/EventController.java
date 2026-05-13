package com.skdev9.eventflow.controller;

import com.skdev9.eventflow.dto.request.CreateEventRequest;
import com.skdev9.eventflow.dto.response.EventResponse;
import com.skdev9.eventflow.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(
            @Valid @RequestBody CreateEventRequest request
    ) {
       EventResponse response = eventService.createEvent(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> findAllEvents() {
        List<EventResponse> events = eventService.findAllEvents();
        return ResponseEntity.ok(events);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> findEventById(
            @PathVariable Long id
    ) {
        EventResponse response = eventService.findEventById(id);
        return ResponseEntity.ok(response);
    }

}
