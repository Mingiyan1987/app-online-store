package ru.basanov.apponlinestore.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.apponlinestore.repository.product.ProductTemplateRepository;

@Service
public class ProductTemplateService {

    private ProductTemplateRepository productTemplateRepository;

    @Autowired
    public ProductTemplateService(ProductTemplateRepository productTemplateRepository) {
        this.productTemplateRepository = productTemplateRepository;
    }
}
