package ru.basanov.apponlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.apponlinestore.model.Account;
import ru.basanov.apponlinestore.model.AccountStatus;
import ru.basanov.apponlinestore.repository.AccountRepository;

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

    public Page<Account> findByAccountStatus(AccountStatus filter, Pageable pageable) {
        return accountRepository.findByAccountStatus(filter, pageable);
    }

    @Transactional
    public void deleteAll() {
        accountRepository.deleteAll();
    }

    @Transactional
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
