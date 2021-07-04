package ru.basanov.apponlinestore.model.product.feature.params;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "feature_params")
@Getter
@Setter
public class FeatureParams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte index = 0;

    @Column(name = "is_involved_in_sorting")
    private boolean isInvolvedInSorting;

    @Column(name = "is_involved_in_pricing")
    private boolean isInvolvedInPricing;

    private String name;

    private boolean visibility;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type")
    private ContentType contentType;

    @ManyToOne
    @JoinColumn(name = "feature_group_id")
    private FeatureGroup featureGroup;

    @Column(name = "is_required")
    private boolean isRequired;
}
