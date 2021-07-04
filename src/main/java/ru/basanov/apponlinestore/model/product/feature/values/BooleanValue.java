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
public class BooleanValue extends FeatureValue<Boolean>{

    private Boolean booleanValue;

    public BooleanValue(Boolean value, FeatureParams featureParams) {
        super(value, featureParams);
    }

    @Override
    public Boolean getValue() {
        return booleanValue;
    }

    @Override
    public void setValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }
}
