package ru.basanov.apponlinestore.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.apponlinestore.repository.order.ReceiptRepository;

@Service
public class ReceiptService {

    private ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }
}
