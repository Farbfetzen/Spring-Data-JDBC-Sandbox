package farbfetzen.springdatajdbcsandbox.model;

import java.time.LocalDateTime;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class Comment {

    private String name;

    private String content;

    private LocalDateTime publishedOn;

    private LocalDateTime updatedOn;

    @Transient
    private Post post;

    public Comment(final String name, final String content) {
        this.name = name;
        this.content = content;
        this.publishedOn = LocalDateTime.now();
    }

}
