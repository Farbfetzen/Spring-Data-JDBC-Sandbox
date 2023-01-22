package farbfetzen.springdatajdbcsandbox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import farbfetzen.springdatajdbcsandbox.model.Account;
import farbfetzen.springdatajdbcsandbox.repository.AccountRepository;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

}
