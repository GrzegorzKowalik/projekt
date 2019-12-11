package cl.reddit.service.post;

import cl.reddit.model.comment.Comment;
import cl.reddit.repository.CommentRepository;

public class CommentService {

    private CommentRepository commentRepository = new CommentRepository();

    public Comment createComment(Comment comment) {
        return getCommentRepository().create(comment);
    }

    private CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
