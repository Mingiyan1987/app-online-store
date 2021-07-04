package ru.basanov.apponlinestore.model.user;

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

    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
