package ru.basanov.apponlinestore.repository.logistic;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.logistic.Mark;

@Repository
public interface MarkRepository extends PagingAndSortingRepository<Mark, Long> {

}
