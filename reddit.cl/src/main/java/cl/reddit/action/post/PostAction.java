package cl.reddit.action.post;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.file.File;
import cl.reddit.model.post.Post;
import cl.reddit.service.post.PostService;
import org.apache.struts2.convention.annotation.*;

import java.util.List;

@ParentPackage("json-default")
@Namespace("/post")
@Results({
        @Result(name = "success", location = "post/postDetails.jsp"),
        @Result(name = "error", location = "post/createPost.jsp"),
        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class PostAction extends AbstractAction {

    private Post post;
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
        setPaginatedPosts(postService.findAll());
        return JSON;
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
