package se331.rest.DAO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Comment;
import se331.rest.entity.Country;
import se331.rest.repository.CommentRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao {
    final CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByCountry(Country country) {
        return commentRepository.findByCountry(country);
    }
}
