package ru.basanov.apponlinestore.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.basanov.apponlinestore.model.*;
import ru.basanov.apponlinestore.model.order.OrderElement;
import ru.basanov.apponlinestore.model.order.ProductStatus;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private Date date;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Account seller;

    @ManyToOne
    @JoinColumn(name = "product_template_id")
    private ProductTemplate template;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderElement> orderElements = new ArrayList<>();

    @ManyToMany
    private Set<Region> regions = new HashSet<>();

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @OrderBy
    private List<Supply> supplyList = new ArrayList<>();


}
