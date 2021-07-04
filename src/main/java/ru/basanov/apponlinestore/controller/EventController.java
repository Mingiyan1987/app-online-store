package ru.basanov.apponlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.basanov.apponlinestore.model.Event;
import ru.basanov.apponlinestore.model.EventType;
import ru.basanov.apponlinestore.service.EventService;

@RestController
public class EventController {

    private static final int PAGE_SIZE = 20;

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    public Event addEvent(@RequestBody Event event) {
        return eventService.saveOrUpdate(event);
    }

    @PutMapping("/event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Event updateEvent(@RequestBody Event event) {
        return eventService.saveOrUpdate(event);
    }

    @DeleteMapping("/event/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEventById(@PathVariable(value = "id") Long id) {
        eventService.deleteById(id);
    }

    @GetMapping(value = "/events/{pageNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Event> getAllEvents(@RequestParam(required = false, defaultValue = "") EventType eventType, @PathVariable(value = "pageNo") int pageNo) {

        Pageable sortedByDate = PageRequest.of(pageNo, PAGE_SIZE, Sort.by("date").ascending());

        if (eventType != null) {
            return eventService.findByType(eventType, sortedByDate);
        }
        return eventService.getAll(sortedByDate);
    }
}
