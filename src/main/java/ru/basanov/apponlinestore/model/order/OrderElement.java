package ru.basanov.apponlinestore.model.order;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.basanov.apponlinestore.model.AbstractPdfKeeper;
import ru.basanov.apponlinestore.model.Region;
import ru.basanov.apponlinestore.model.product.Product;
import ru.basanov.apponlinestore.model.product.Review;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureParams;
import ru.basanov.apponlinestore.model.product.feature.values.FeatureValue;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "order_element")
public class OrderElement extends AbstractPdfKeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(mappedBy = "orderElement")
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "product_order_id")
    private ProductOrder order;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    private int price;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private OrderElementStatus status = OrderElementStatus.NOT_CONFIRMED;

    @Column(name = "pay_date")
    private Instant payDate;

    @OneToMany(mappedBy = "orderElement",
                cascade = CascadeType.ALL)
    @MapKey(name = "featureParams")
    private Map<FeatureParams, FeatureValue> featureParamsFeatureValues = new HashMap<>();


}
