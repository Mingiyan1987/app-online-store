package ru.basanov.apponlinestore.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.apponlinestore.repository.order.RefundRepository;

@Service
public class RefundService {

    private RefundRepository refundRepository;

    @Autowired
    public RefundService(RefundRepository refundRepository) {
        this.refundRepository = refundRepository;
    }
}
