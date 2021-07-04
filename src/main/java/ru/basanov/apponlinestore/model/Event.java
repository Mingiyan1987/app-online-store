package ru.basanov.apponlinestore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date date;

    @Enumerated(EnumType.STRING)
    private EventType type;

    public Event(Long id, String name, Date date, EventType eventType) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = eventType;
    }
}
