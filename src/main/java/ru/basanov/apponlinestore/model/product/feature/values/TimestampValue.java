package ru.basanov.apponlinestore.model.product.feature.values;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
@Getter
@Setter
public class TimestampValue extends FeatureValue<Instant> {

    private Instant timestampValue;

    @Override
    public Instant getValue() {
        return null;
    }

    @Override
    public void setValue(Instant value) {

    }
}
