package cl.reddit.repository;

import cl.reddit.model.post.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PostRepository extends AbstractRepository<Post> {

    private Logger log = LoggerFactory.getLogger(PostRepository.class);


    public Post findById(Long id) {
        return super.findById(id, Post.class);
    }

    public List<Post> findAll() {
        return super.findAll(Post.class);
    }

    public boolean delete(Long id) {
        return super.delete(id, Post.class);
    }

    @Override
    public Post create(Post post) {
        post.setId((Long)super.create(post));
        return post;
    }
}
