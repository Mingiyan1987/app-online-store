package ru.basanov.apponlinestore.model.product.feature.values;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class ListFeatureValueList extends FeatureValue<List<FeatureValue>> {

    @OneToMany(mappedBy = "parentValue", cascade = ALL)
    private List<FeatureValue> valueList = new ArrayList<>();

    @Override
    public List<FeatureValue> getValue() {
        return valueList;
    }

    @Override
    public void setValue(List<FeatureValue> value) {
        this.valueList = value;
    }
}
