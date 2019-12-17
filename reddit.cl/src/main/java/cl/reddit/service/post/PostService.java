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
        return findById(post.getId());
    }

    public Post findById(Long idPost) {
        return getPostRepository().findById(idPost);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findByIdUser(Long idUser) {
        return postRepository.findByIdUser(idUser);
    }

    private PostRepository getPostRepository() {
        return postRepository;
    }

    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
