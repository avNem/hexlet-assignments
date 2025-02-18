package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PostRepository postRepository;

  @GetMapping("")
  public List<PostDTO> getAllPost() {
    return postRepository.findAll().stream()
        .map(this::toPostDto)
        .toList();
  }

  @GetMapping("/{id}")
  public PostDTO getPostById(@PathVariable Long id) {
    var res = postRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    return toPostDto(res);
  }


  private PostDTO toPostDto(Post post) {
    var dto = new PostDTO();
    dto.setId(post.getId());
    dto.setComments(commentRepository.findByPostId(post.getId()).stream()
        .map(this::toCommentDto).toList());
    dto.setTitle(post.getTitle());
    dto.setBody(post.getBody());
    return dto;
  }

  private CommentDTO toCommentDto(Comment comment) {
    var dto = new CommentDTO();
    dto.setId(comment.getId());
    dto.setBody(comment.getBody());
    return dto;
  }
}
// END
