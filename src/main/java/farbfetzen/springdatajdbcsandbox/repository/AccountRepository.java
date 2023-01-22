package farbfetzen.springdatajdbcsandbox.repository;

import org.springframework.data.repository.CrudRepository;

import farbfetzen.springdatajdbcsandbox.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
