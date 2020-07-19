package ru.basanov.apponlinestore.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.apponlinestore.model.user.Account;
import ru.basanov.apponlinestore.repository.user.AccountRepository;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account saveOrUpdate(Account account) {
        accountRepository.save(account);
        return account;
    }

    @Transactional(readOnly = true)
    public Page<Account> getAll(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);

        return accounts;
    }
/*
    public Page<Account> findAccountByAccountStatus(AccountStatus filter, Pageable pageable) {
        return accountRepository.findAccountByAccountStatus(filter, pageable);
    }
*/
    @Transactional
    public void deleteAll() {
        accountRepository.deleteAll();
    }

    @Transactional
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    public List<Account> getAll() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(accountRepository.findAll().iterator(), Spliterator.ORDERED), false)
                .collect(Collectors.toList());
    }
}
