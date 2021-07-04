package ru.basanov.apponlinestore.model.product.feature.values;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.basanov.apponlinestore.model.product.Document;
import ru.basanov.apponlinestore.model.product.feature.params.FeatureParams;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "document_value")
public class DocumentValue extends FeatureValue<Document> {

    @OneToOne(mappedBy = "documentValue")
    private Document document;

    public DocumentValue(Document document, FeatureParams featureParams) {
        super(document, featureParams);
    }

    @Override
    public Document getValue() {
        return document;
    }

    @Override
    public void setValue(Document document) {
        this.document = document;
    }

}
