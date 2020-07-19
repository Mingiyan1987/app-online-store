package ru.basanov.apponlinestore.repository.product.values;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.product.feature.values.IntegerValue;

@Repository
public interface IntegerValueRepository extends PagingAndSortingRepository<IntegerValue, Long> {

}
