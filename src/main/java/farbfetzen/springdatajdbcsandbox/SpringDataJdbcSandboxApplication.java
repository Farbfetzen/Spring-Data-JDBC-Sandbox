package farbfetzen.springdatajdbcsandbox;

import static farbfetzen.springdatajdbcsandbox.model.Role.ADMIN;
import static farbfetzen.springdatajdbcsandbox.model.Role.USER;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import farbfetzen.springdatajdbcsandbox.model.Account;
import farbfetzen.springdatajdbcsandbox.model.Author;
import farbfetzen.springdatajdbcsandbox.model.Comment;
import farbfetzen.springdatajdbcsandbox.model.Post;
import farbfetzen.springdatajdbcsandbox.model.Role;
import farbfetzen.springdatajdbcsandbox.repository.AccountRepository;
import farbfetzen.springdatajdbcsandbox.repository.AuthorRepository;
import farbfetzen.springdatajdbcsandbox.repository.PostRepository;

@SpringBootApplication
public class SpringDataJdbcSandboxApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringDataJdbcSandboxApplication.class, args);
    }

    @Bean
    CommandLineRunner blogCommandLineRunner(final PostRepository postRepository, final AuthorRepository authorRepository) {
        return args -> {
            Author author =new Author(null, "Theo", "Test", "theo.test@example.com", "theotest");
            author = authorRepository.save(author);
            final Post post = new Post("Hello, World!", "Welcome to my blog!", AggregateReference.to(author.id()));
            post.addComment(new Comment("Ben", "This is my first comment."));
            postRepository.save(post);
        };
    }

    @Bean
    CommandLineRunner accountCommandLineRunner(final AccountRepository accountRepository) {
        return args -> {
            final Set<Role> roles = Set.of(new Role(ADMIN), new Role(USER));
            final Account sebastian = new Account("Sebastian", "sebastian@example.com", roles);
            accountRepository.save(sebastian);
        };
    }

}
