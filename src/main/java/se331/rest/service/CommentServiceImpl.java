package se331.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.rest.DAO.CommentDao;
import se331.rest.entity.Comment;
import se331.rest.entity.Country;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    final CommentDao commentDao;

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public List<Comment> getCommentsByCountry(Country country) {
        return commentDao.getCommentsByCountry(country);
    }
}
