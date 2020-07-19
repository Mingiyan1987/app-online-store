package ru.basanov.apponlinestore.model.product.feature.values;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DateValue extends FeatureValue<Date> {

    private Date dateValue;


    @Override
    public Date getValue() {
        return dateValue;
    }

    @Override
    public void setValue(Date value) {
        this.dateValue = dateValue;
    }
}
