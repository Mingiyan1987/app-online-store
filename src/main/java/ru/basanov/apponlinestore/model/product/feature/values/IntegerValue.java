package ru.basanov.apponlinestore.model.product.feature.values;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureParams;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IntegerValue extends FeatureValue<Integer> {

    @Column(name = "integer_value")
    private Integer integerValue;

    public IntegerValue(Integer value, FeatureParams featureParams) {
        super(value, featureParams);
    }

    @Override
    public Integer getValue() {
        return integerValue;
    }

    @Override
    public void setValue(Integer value) {
        this.integerValue = integerValue;
    }
}
