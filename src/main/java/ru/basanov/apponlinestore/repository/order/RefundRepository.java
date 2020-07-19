package ru.basanov.apponlinestore.repository.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.order.Refund;

@Repository
public interface RefundRepository extends PagingAndSortingRepository<Refund, Long> {

}
