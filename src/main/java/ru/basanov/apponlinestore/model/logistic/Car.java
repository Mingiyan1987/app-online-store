package ru.basanov.apponlinestore.model.logistic;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.basanov.apponlinestore.model.ComboListItem;
import ru.basanov.apponlinestore.model.user.Account;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String grz;

    @ManyToOne
    @JsonIdentityReference
    @JsonSerialize(as = ComboListItem.class)
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
