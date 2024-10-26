package se331.rest.service;

import se331.rest.entity.Comment;
import se331.rest.entity.Country;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getCommentsByCountry(Country country);
}
