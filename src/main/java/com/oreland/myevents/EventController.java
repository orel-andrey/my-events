package com.oreland.myevents;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<Set<EventDto>> getEvents() throws IOException {
        return ResponseEntity.ok(eventService.getEvents().stream()
                .map(EventDto::new)
                .collect(Collectors.toSet()));
    }
}
