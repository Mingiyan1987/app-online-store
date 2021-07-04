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
public class StringValue extends FeatureValue<String> {

    @Column(name = "string_value")
    private String stringValue;

    public StringValue(String value, FeatureParams featureParams) {
        super(value, featureParams);
    }

    @Override
    public String getValue() {
        return stringValue;
    }

    @Override
    public void setValue(String value) {
        this.stringValue = value;
    }
}
