package farbfetzen.springdatajdbcsandbox.model.dto;

import farbfetzen.springdatajdbcsandbox.model.Author;
import farbfetzen.springdatajdbcsandbox.model.Post;

public record PostDetails(Post post, Author author) {
}
