package cl.reddit.service.post;

import cl.reddit.model.post.Post;
import cl.reddit.repository.PostRepository;

import java.util.List;

public class PostService {

    private PostRepository postRepository = new PostRepository();

    public Post createPost(Post post) {
        return getPostRepository().create(post);
    }

    public Post findById(Post post) {
        return getPostRepository().findById(post.getId());
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    private PostRepository getPostRepository() {
        return postRepository;
    }

    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
