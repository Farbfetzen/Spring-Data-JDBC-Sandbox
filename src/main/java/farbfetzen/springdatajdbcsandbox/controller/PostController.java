package farbfetzen.springdatajdbcsandbox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import farbfetzen.springdatajdbcsandbox.dto.PostDetails;
import farbfetzen.springdatajdbcsandbox.model.Author;
import farbfetzen.springdatajdbcsandbox.model.Post;
import farbfetzen.springdatajdbcsandbox.repository.AuthorRepository;
import farbfetzen.springdatajdbcsandbox.repository.PostRepository;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final AuthorRepository authorRepository;

    private final PostRepository postRepository;

    @GetMapping
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable final Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/details")
    public PostDetails getPostDetails(@PathVariable final Integer id) {
        final Post post = postRepository.findById(id).orElse(null);
        final Author author = post == null ? null : authorRepository.findById(post.getId()).orElse(null);
        return new PostDetails(post, author);
    }

}
