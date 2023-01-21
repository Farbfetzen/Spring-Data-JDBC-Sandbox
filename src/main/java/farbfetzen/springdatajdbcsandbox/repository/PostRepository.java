package farbfetzen.springdatajdbcsandbox.repository;

import org.springframework.data.repository.CrudRepository;

import farbfetzen.springdatajdbcsandbox.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
