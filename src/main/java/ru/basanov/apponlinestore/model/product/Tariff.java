package ru.basanov.apponlinestore.model.product;

import javax.persistence.*;

@Entity
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
