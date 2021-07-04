package ru.basanov.apponlinestore.repository.logistic;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.logistic.Waybill;

@Repository
public interface WaybillRepository extends PagingAndSortingRepository<Waybill, Long> {

}
