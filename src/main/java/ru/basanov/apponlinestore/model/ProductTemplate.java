package ru.basanov.apponlinestore.model;

import lombok.NoArgsConstructor;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureGroup;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureParams;
import ru.basanov.apponlinestore.model.product.feature.params.DeliveryType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_template")
@NoArgsConstructor
public class ProductTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "short_name")
    private String shortName;

    private String description;

    @Column(name = "is_tariff_type")
    private boolean isTariffType = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "default_delivery_type")
    private DeliveryType defaultDeliveryType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initialprice_id")
    private FeatureParams initialPrice;

    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "product_template_specific")
    @OrderBy("index")
    private List<FeatureGroup> specificFeatureGroups = new ArrayList<>();

    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "product_template_plugin_options")
    @OrderBy("index")
    private List<FeatureGroup> pluginOptions = new ArrayList<>();

    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "product_template_pricing_options")
    @OrderBy("index")
    private List<FeatureGroup> pricingOptions = new ArrayList<>();

    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "product_template_discounts")
    @OrderBy("index")
    private List<FeatureGroup> discounts = new ArrayList<>();

    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "product_template_delivery")
    @OrderBy("index")
    private List<DeliveryFeatureGroup> delivery = new ArrayList<>();

    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "product_template_customer_delivery")
    @OrderBy("index")
    private List<FeatureGroup> customerSpecOptions = new ArrayList<>();

    /** Кэшированное значение, используемое поиском, есть ли такой FeatureParams в любой из групп */
    @Transient
    private transient List<FeatureParams> mergedFeatureParams;
}
