package ru.basanov.apponlinestore.repository.product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.product.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
