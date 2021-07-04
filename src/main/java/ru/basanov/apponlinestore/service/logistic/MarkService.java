package ru.basanov.apponlinestore.service.logistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.apponlinestore.repository.logistic.MarkRepository;

@Service
public class MarkService {

    private MarkRepository markRepository;

    @Autowired
    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }
}
