package ru.basanov.apponlinestore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.Account;
import ru.basanov.apponlinestore.model.AccountStatus;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Page<Account> findByAccountStatus(AccountStatus filter, Pageable pageable);
}
