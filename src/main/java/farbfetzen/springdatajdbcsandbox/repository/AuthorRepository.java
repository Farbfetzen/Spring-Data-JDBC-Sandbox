package farbfetzen.springdatajdbcsandbox.repository;

import org.springframework.data.repository.CrudRepository;

import farbfetzen.springdatajdbcsandbox.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
