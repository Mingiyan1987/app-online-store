package ru.basanov.apponlinestore.service.logistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.apponlinestore.repository.logistic.SupplyRepository;

@Service
public class SupplyService {

    private SupplyRepository supplyRepository;

    @Autowired
    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }
}
