package ru.basanov.apponlinestore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.basanov.apponlinestore.model.product.feature.params.DeliveryType;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureGroup;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureParams;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class DeliveryFeatureGroup extends FeatureGroup {

    @Enumerated(EnumType.STRING)
    private DeliveryType type;

    public DeliveryFeatureGroup(DeliveryType type, byte index) {
        super();
        setName(type.getName());
        this.type = type;
        setIndex(index);
    }

    public DeliveryFeatureGroup(DeliveryType type, byte index, List<FeatureParams> featureParams) {
        this.type = type;
        setIndex(index);
        setFeatureParamsList(featureParams);
    }
}
