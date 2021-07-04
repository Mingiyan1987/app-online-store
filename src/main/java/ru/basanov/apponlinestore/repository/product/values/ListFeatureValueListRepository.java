package ru.basanov.apponlinestore.repository.product.values;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.product.feature.values.ListFeatureValueList;

@Repository
public interface ListFeatureValueListRepository extends PagingAndSortingRepository<ListFeatureValueList, Long> {
}
