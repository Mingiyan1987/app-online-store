package ru.basanov.apponlinestore.repository.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.order.Receipt;

@Repository
public interface ReceiptRepository extends PagingAndSortingRepository<Receipt, Long> {

}
