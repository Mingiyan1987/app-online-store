package ru.basanov.apponlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.basanov.apponlinestore.model.Event;
import ru.basanov.apponlinestore.model.EventType;
import ru.basanov.apponlinestore.service.EventService;

@RestController
public class EvenController {

    private static final int PAGE_SIZE = 20;

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public Event addEvent(@RequestBody Event event) {
        System.out.println(event.getDate());
        return eventService.saveOrUpdate(event);
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
