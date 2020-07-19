package ru.basanov.apponlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import ru.basanov.apponlinestore.model.product.Product;
import ru.basanov.apponlinestore.model.product.Review;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String patronomic;

    private String login;

    private String password;

    @CreationTimestamp
    private Date date;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(name = "registration_date")
    private Instant registrationDate;

    public Account(Long id, String lastName, String firstName, String patronomic, String login, String password, Date date, int age, Gender gender) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronomic = patronomic;
        this.login = login;
        this.password = password;
        this.date = date;
        this.age = age;
        this.gender = gender;
    }

    public Double countRating() {
        return products.stream()
                .flatMap(p -> p.getReviews().stream())
                .mapToInt(Review::getFamePoints)
                .average().orElse(0D);
    }
}
