package farbfetzen.springdatajdbcsandbox.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Post {

    @Id
    private Integer id;

    private String title;

    private String content;

    private LocalDateTime publishedOn;

    private LocalDateTime updatedOn;

    private AggregateReference<Author, Integer> author;

    private Set<Comment> comments = new HashSet<>();

    public Post(final String title, final String content, final AggregateReference<Author, Integer> author) {
        this.title = title;
        this.content = content;
        this.publishedOn = LocalDateTime.now();
        this.author = author;
    }

    public void addComment(final Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

}
