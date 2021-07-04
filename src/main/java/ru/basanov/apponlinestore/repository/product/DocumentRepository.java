package ru.basanov.apponlinestore.repository.product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.product.Document;

@Repository
public interface DocumentRepository extends PagingAndSortingRepository<Document, Long> {

}
