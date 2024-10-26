package se331.rest.DAO;

import se331.rest.entity.Comment;
import se331.rest.entity.Country;

import java.util.List;

public interface CommentDao {
    Comment addComment(Comment comment);
    List<Comment> getCommentsByCountry(Country country);
}
