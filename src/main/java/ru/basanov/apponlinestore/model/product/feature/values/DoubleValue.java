package ru.basanov.apponlinestore.model.product.feature.values;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureParams;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DoubleValue extends FeatureValue<Double>{

    private Double doubleValue;

    public DoubleValue(Double value, FeatureParams featureParams) {
        super(value, featureParams);
    }

    @Override
    public Double getValue() {
        return null;
    }

    @Override
    public void setValue(Double value) {

    }
}
