package ru.basanov.apponlinestore.model.logistic;

import ru.basanov.apponlinestore.model.product.Product;

import javax.persistence.*;

@Entity
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    private int price;

}
