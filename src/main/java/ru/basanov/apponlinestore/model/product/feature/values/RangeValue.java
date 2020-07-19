package ru.basanov.apponlinestore.model.product.feature.values;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class RangeValue extends FeatureValue<String> {

    private Integer leftValue;

    private Integer rightValue;

    @Override
    public String getValue() {
        return leftValue + ";" + rightValue;
    }

    @Override
    public void setValue(String value) {
        if (value != null && !value.equals("null;null")) {
            int index = value.indexOf(";");
            leftValue = Integer.parseInt(value.substring(0, index));
            rightValue = Integer.parseInt(value.substring(index + 1));
        }
    }
}
