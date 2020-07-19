package ru.basanov.apponlinestore.model.logistic;

import ru.basanov.apponlinestore.model.AbstractPdfKeeper;
import ru.basanov.apponlinestore.model.user.Account;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "waybill")
public class Waybill extends AbstractPdfKeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Instant validity;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToMany(mappedBy = "waybill")
    private List<Supply> supply;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Account driver;


}
