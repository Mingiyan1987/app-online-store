package ru.basanov.apponlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.apponlinestore.model.Event;
import ru.basanov.apponlinestore.model.EventType;
import ru.basanov.apponlinestore.repository.EventRepository;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Event saveOrUpdate(Event event) {
        eventRepository.save(event);
        return event;
    }

    @Transactional(readOnly = true)
    public Page<Event> getAll(Pageable pageable) {
        Page<Event> events = eventRepository.findAll(pageable);

        return events;
    }

    public List<Event> getAllEventList() {
        return null;
    }

    public Page<Event> findByType(EventType filter, Pageable pageable) {
        return eventRepository.findByType(filter, pageable);
    }


}
