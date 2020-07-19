package ru.basanov.apponlinestore.model.product.feature.params;

import ru.basanov.apponlinestore.model.product.feature.values.*;

public enum ContentType {

    STRING(StringValue.class),

    DOCUMENT(DocumentValue.class),

    INTEGER(IntegerValue.class),

    BOOLEAN(BooleanValue.class),

    DATE(DateValue.class),

    RANGE(RangeValue.class),

    DOUBLE(DoubleValue.class),

    GEO_COORDINATES(GeoCoordinatesValue.class),

    LIST_OF_CHOICES(StringValue.class);

    private Class<? extends FeatureValue> value;

    ContentType(Class<? extends FeatureValue> value) {
        this.value = value;
    }

    public FeatureValue createValue() {
        try {
            return value.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
