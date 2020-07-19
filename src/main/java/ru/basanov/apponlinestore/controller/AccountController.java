package ru.basanov.apponlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.basanov.apponlinestore.model.user.Account;
import ru.basanov.apponlinestore.model.user.AccountStatus;
import ru.basanov.apponlinestore.service.user.AccountService;

@RestController
public class AccountController {

    private static final int PAGE_SIZE = 15;

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addAccount(@RequestBody Account account) {
        return accountService.saveOrUpdate(account);
    }

    @PutMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@RequestBody Account account) {
        return accountService.saveOrUpdate(account);
    }

    @DeleteMapping("/account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountById(@PathVariable(value = "id") Long id) {
        accountService.deleteById(id);
    }

    @DeleteMapping("/accounts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        accountService.deleteAll();
    }

    @GetMapping(value = "{pageNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Account> getAllAccounts(@RequestParam(required = false, defaultValue = "") AccountStatus accountStatus,
                                        @PathVariable(value = "pageNo") int pageNo) {

        Pageable sortedByDate = PageRequest.of(pageNo, PAGE_SIZE, Sort.by("date").ascending());
/*
        if (accountStatus != null) {
            return accountService.findAccountByAccountStatus(accountStatus, sortedByDate);
        }
*/
        return accountService.getAll(sortedByDate);
    }

    @GetMapping("/account/averageAge")
    public Double getAverage() {
        return accountService.getAll().stream().mapToInt(Account::getAge).average().getAsDouble();
    }

}
