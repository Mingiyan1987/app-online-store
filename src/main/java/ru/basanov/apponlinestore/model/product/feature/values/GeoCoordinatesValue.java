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
public class GeoCoordinatesValue extends FeatureValue<String> {

    private String coordinates;

    public GeoCoordinatesValue(String value, FeatureParams featureParams) {
        super(value, featureParams);
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void setValue(String value) {

    }
}
