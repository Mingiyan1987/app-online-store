package ru.basanov.apponlinestore.model.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.basanov.apponlinestore.model.user.Account;
import ru.basanov.apponlinestore.model.order.OrderElement;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Account author;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "fame_points")
    private byte famePoints;

    private String comment;

    @Column(name = "admin_answer")
    private String adminAnswer;

    @Column(name = "created_date")
    private Instant createdDate = Instant.now();

    @OneToOne
    private OrderElement orderElement;

    public Review(Account author, Product product, byte famePoints, String comment) {
        this.author = author;
        this.product = product;
        this.famePoints = famePoints;
        this.comment = comment;
    }
}
