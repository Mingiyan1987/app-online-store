package ru.basanov.apponlinestore.repository.product.params;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.product.feature.params.DeliveryFeatureGroup;

@Repository
public interface DeliveryFeatureGroupRepository extends PagingAndSortingRepository<DeliveryFeatureGroup, Long> {

}
