package ru.basanov.apponlinestore.model.product.feature.values;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.basanov.apponlinestore.model.order.OrderElement;
import ru.basanov.apponlinestore.model.logistic.Waybill;
import ru.basanov.apponlinestore.model.product.Product;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureParams;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "feature_value")
public abstract class FeatureValue<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "featureparams_id")
    private FeatureParams featureParams;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderelement_id")
    private OrderElement orderElement;

    @ManyToOne
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    @ManyToOne
    @JoinColumn(name = "parentvalue_id")
    private FeatureValue parentValue;

    public FeatureValue(T value, FeatureParams featureParams) {
        setValue(value);
        this.featureParams = featureParams;
    }

    public abstract T getValue();

    public abstract void setValue(T value);
}
