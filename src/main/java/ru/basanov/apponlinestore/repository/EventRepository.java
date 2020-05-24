package ru.basanov.apponlinestore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.Event;
import ru.basanov.apponlinestore.model.EventType;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    Page<Event> findByType(EventType eventType, Pageable pageable);

}
