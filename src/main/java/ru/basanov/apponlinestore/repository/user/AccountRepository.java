package ru.basanov.apponlinestore.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.user.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    //Page<Account> findAccountByAccountStatus(AccountStatus status, Pageable pageable);

}
