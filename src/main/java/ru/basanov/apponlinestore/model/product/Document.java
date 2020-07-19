package ru.basanov.apponlinestore.model.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.basanov.apponlinestore.model.product.feature.values.DocumentValue;

import javax.persistence.*;

@Entity
@Table(name = "document")
@Getter
@Setter
@ToString
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    private String description;

    @OneToOne
    @JoinColumn(name = "document_value_id")
    private DocumentValue documentValue;
}
