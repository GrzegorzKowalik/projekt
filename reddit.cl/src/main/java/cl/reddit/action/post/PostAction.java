package cl.reddit.action.post;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.comment.Comment;
import cl.reddit.model.file.File;
import cl.reddit.model.post.Post;
import cl.reddit.model.post.dto.PostDTO;
import cl.reddit.model.user.User;
import cl.reddit.service.post.PostService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@ParentPackage("json-default")
@Namespace("/post")
@Results({
        @Result(name = "success", location = "postDetails.jsp"),
        @Result(name = "error", location = "upload.jsp"),
        @Result(name = "add", location = "createPost.jsp"),
        @Result(name = "commentError", location = "postDetails.jsp"),
        @Result(name = "input", location = "postDetails.jsp"),
        @Result(name = "upload", location = "upload.jsp")
//        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class PostAction extends AbstractAction {

    private Post post;
    private Comment comment;
    private User user;
    private Long postId;
    private List<Post> paginatedPosts;
    private List<java.io.File> files;
    private java.io.File file;
    private List<File> fileDTOs;
    private PostDTO postDTO;
    private List<String> contentTypes;
    private List<String> filenames;

    private static final String COMMENT_ERROR = "commentError";
    private static final String UPLOAD = "upload";


    @Action("add-post")
    public String addPost() {
        if(getPostDTO() != null) {
            getPostDTO().setIdUser(getUserFromSession().getId());
            setPost(getPostService().createPost(getPostDTO()));
            if (files != null && files.size() > 0) {
                setFileDTOs(new ArrayList<>(files.size()));
                for (int i = 0; i < files.size(); i++) {
                    String[] filename = getFilesFileName().get(i).split("\\.");
                    long stamp = System.currentTimeMillis();
                    java.io.File temp = new java.io.File(System.getProperty("user.dir") + "\\static\\" + filename[0] + "_" + stamp + "." + filename[1]);
                    java.io.File temp2 = new java.io.File(System.getProperty("user.dir") + "\\static\\" + filename[0] + "_" + stamp + "." + filename[1]);
                    try(FileInputStream fis = new FileInputStream(files.get(i));
                        FileOutputStream fos = new FileOutputStream(temp);
                        FileOutputStream fos2 = new FileOutputStream(temp2);
                        ){
                        int c;
                        while ((c = fis.read()) != -1) {
                            fos.write(c);
                            fos2.write(c);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    File dto = new File();
                    dto.setPath("/static/" + temp.getName());
                    dto.setPost(getPost());
                    dto.setUser(getUserFromSession());
                    getFileDTOs().add(dto);
                }
                fileDTOs.forEach(x -> getFileService().createFile(x));
            }
            setPost(getPostService().findById(getPost()));
            if (getPost() != null && getPost().getId() != null && getPost().getId() > 0) {
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

    @Action("upload")
    public String upload() {
        return UPLOAD;
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
        if (getComment() != null && getUserFromSession() != null) {
            if(StringUtils.isBlank(getComment().getBody())){
                addFieldError("comment.body", "Write something!");
                errors = true;
            }
            Post post = new Post();
            post.setId(getPostId());
            getComment().setPost(post);
            getComment().setUser(getUserFromSession());
            if (!errors) {
                setComment(commentService.createComment(getComment()));
                if (getComment() != null) {
                    setPost(postService.findById(post));
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List<java.io.File> getFiles() {
        return files;
    }

    public void setFiles(List<java.io.File> files) {
        this.files = files;
    }

    public List<File> getFileDTOs() {
        return fileDTOs;
    }

    public void setFileDTOs(List<File> fileDTOs) {
        this.fileDTOs = fileDTOs;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public java.io.File getFile() {
        return file;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    public List<String> getFilesContentType() {
        return contentTypes;
    }

    public void setFilesContentType(List<String> contentType) {
        this.contentTypes = contentType;
    }

    public List<String> getFilesFileName() {
        return filenames;
    }

    public void setFilesFileName(List<String> filename) {
        this.filenames = filename;
    }
}
