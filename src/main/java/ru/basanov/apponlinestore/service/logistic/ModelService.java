package ru.basanov.apponlinestore.service.logistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.apponlinestore.repository.logistic.ModelRepository;

@Service
public class ModelService {

    private ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
