package ru.basanov.apponlinestore.repository.product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.product.Tariff;

@Repository
public interface TariffRepository extends PagingAndSortingRepository<Tariff, Long> {

}
