package cl.reddit.repository;

import cl.reddit.model.comment.Comment;

import java.util.List;

public class CommentRepository extends AbstractRepository<Comment> {

    public Comment findById(Long id) {
        return super.findById(id, Comment.class);
    }

    public List<Comment> findAll() {
        return super.findAll(Comment.class);
    }

    public boolean delete(Long id) {
        return super.delete(id, Comment.class);
    }

    @Override
    public Comment create(Comment comment) {
        comment.setId((Long)super.create(comment));
        return comment;
    }
}
