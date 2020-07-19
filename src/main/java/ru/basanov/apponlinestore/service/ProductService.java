package ru.basanov.apponlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.apponlinestore.model.product.Product;
import ru.basanov.apponlinestore.model.order.ProductStatus;
import ru.basanov.apponlinestore.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        productRepository.deleteAll();
    }

    public Page<Product> findByStatus(ProductStatus filter, Pageable pageable) {
        productRepository.findByStatus(filter, pageable);
        return null;
    }

    @Transactional(readOnly = true)
    public Page<Product> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products;
    }

}
