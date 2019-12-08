package cl.reddit.action.post;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.file.File;
import cl.reddit.model.post.Post;
import cl.reddit.model.user.User;
import cl.reddit.service.post.PostService;
import org.apache.struts2.convention.annotation.*;

import java.util.List;
import java.util.Map;

@ParentPackage("json-default")
@Namespace("/post")
@Results({
        @Result(name = "success", location = "postDetails.jsp"),
        @Result(name = "error", location = "createPost.jsp"),
        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class PostAction extends AbstractAction {

    private Post post;
    private User user;
    private List<Post> paginatedPosts;
    private List <java.io.File> files;
    private List <File> fileModels;
    private PostService postService = new PostService();

    @Action("add-post")
    public String addPost() {
        if(getPost() != null) {
            setPost(postService.createPost(getPost()));
            if (getPost() != null && getPost().getId() != null && getPost().getId() > 0){
                return SUCCESS;
            }
        }
        return ERROR;
    }

    @Action("show-details")
    public String showDetails() {
        if(getPost() != null) {
            setPost(postService.findById(getPost()));
            if(getPost() != null) {
                return SUCCESS;
            }
        }
        return ERROR;
    }

    @Action("upload-files")
    public String uploadFiles() {
        return SUCCESS;
    }

    @Action("get-posts")
    public String getPosts() {
        user = getUserFromSession();
            setPaginatedPosts(postService.findAll());
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getPaginatedPosts() {
        return paginatedPosts;
    }

    public void setPaginatedPosts(List<Post> paginatedPosts) {
        this.paginatedPosts = paginatedPosts;
    }
}
