package ru.basanov.apponlinestore.repository.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.order.Payment;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
}
