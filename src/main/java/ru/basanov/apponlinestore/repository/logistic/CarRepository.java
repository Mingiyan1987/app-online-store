package ru.basanov.apponlinestore.repository.logistic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.basanov.apponlinestore.model.logistic.Car;


public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    @Override
    @EntityGraph(attributePaths = {"model.mark"})
    Page<Car> findAll(Pageable pageable);
}
