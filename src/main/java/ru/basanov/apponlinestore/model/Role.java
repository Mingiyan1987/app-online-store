package ru.basanov.apponlinestore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}