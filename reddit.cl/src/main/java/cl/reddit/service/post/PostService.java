package cl.reddit.service.post;

import cl.reddit.model.category.Category;
import cl.reddit.model.post.Post;
import cl.reddit.model.post.dto.PostDTO;
import cl.reddit.model.user.User;
import cl.reddit.repository.PostRepository;

import java.util.List;

public class PostService {

    private PostRepository postRepository = new PostRepository();

    public Post createPost(Post post) {
        return getPostRepository().create(post);
    }

    public Post createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setBody(postDTO.getBody());
        post.setTitle(postDTO.getTitle());
        User user = new User();
        user.setId(postDTO.getIdUser());
        post.setUser(user);
        Category category = new Category();
        category.setId(postDTO.getIdCategory());
        post.setCategory(category);
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

    public List<Post> findByIdCategory(Long idCategory) {
        return postRepository.findByIdCategory(idCategory);
    }

    private PostRepository getPostRepository() {
        return postRepository;
    }

    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
