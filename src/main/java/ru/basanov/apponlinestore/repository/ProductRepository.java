package ru.basanov.apponlinestore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.product.Product;
import ru.basanov.apponlinestore.model.order.ProductStatus;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findByStatus(ProductStatus filter, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"template.initialPrice"})
    Page<Product> findAll(Pageable pageable);
}
