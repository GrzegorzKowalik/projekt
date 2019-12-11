package cl.reddit.action.post;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.comment.Comment;
import cl.reddit.model.file.File;
import cl.reddit.model.post.Post;
import cl.reddit.model.user.User;
import cl.reddit.service.post.PostService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;

import java.util.List;

@ParentPackage("json-default")
@Namespace("/post")
@Results({
        @Result(name = "success", location = "postDetails.jsp"),
        @Result(name = "error", location = "createPost.jsp"),
        @Result(name = "add", location = "createPost.jsp"),
        @Result(name = "commentError", location = "postDetails.jsp"),
        @Result(name = "input", location = "postDetails.jsp"),
        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class PostAction extends AbstractAction {

    private Post post;
    private Comment comment;
    private User user;
    private List<Post> paginatedPosts;
    private List <java.io.File> files;
    private List <File> fileModels;

    private static final String COMMENT_ERROR = "commentError";


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

    @Action("add-comment")
    public String addComment() {
        boolean errors = false;
        if (getComment() != null && getUser() != null && getPost() != null) {
            if(StringUtils.isBlank(getComment().getBody())){
                addFieldError("comment.body", "Write something!");
                errors = true;
            }
            getComment().setPost(getPost());
            getComment().setUser(getUser());
            if (!errors) {
                setComment(commentService.createComment(getComment()));
                if (getComment() != null) {
                    setPost(getComment().getPost());
                    return SUCCESS;
                }
            }
        }
        return COMMENT_ERROR;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
