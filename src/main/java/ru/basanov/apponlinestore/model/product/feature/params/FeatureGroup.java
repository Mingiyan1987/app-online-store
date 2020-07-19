package ru.basanov.apponlinestore.model.product.feature.params;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.basanov.apponlinestore.model.ProductTemplate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "feature_group")
public class FeatureGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte index = 0;

    private String name;

    @OneToMany(mappedBy = "featureGroup", orphanRemoval = true)
    @OrderBy("index")
    private List<FeatureParams> featureParamsList = new ArrayList<>();

    @ManyToOne(optional = true)
    @JoinColumn(name = "product_template_id")
    private ProductTemplate productTemplate;

    public FeatureGroup(String name, byte index) {
        this.name = name;
        this.index = index;
    }

    public FeatureGroup(String name, byte index, List<FeatureParams> featureParams) {
        this.index = index;
        this.name = name;
        this.featureParamsList = featureParams;
    }

    /**
     * Получить параметр этой группы по его названию. Если такого параметра нет,
     * то вернет null.
     * @param name
     * @return
     */
    public FeatureParams getFeatureParamByName(String name) {
        return featureParamsList.stream()
                .filter(fp -> fp.getName().equals(name))
                .findFirst().orElse(null);
    }
}
