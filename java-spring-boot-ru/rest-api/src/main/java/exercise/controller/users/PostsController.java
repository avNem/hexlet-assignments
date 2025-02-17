package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

  List<Post> posts = Data.getPosts();

  @GetMapping("/users/{id}/posts")
  public ResponseEntity<List<Post>> getAll(@PathVariable int id) {
    var result = posts.stream()
        .filter(p -> p.getUserId() == id)
        .toList();
    return ResponseEntity.ok(result);
  }

  @PostMapping("/users/{id}/posts")
  @ResponseStatus(HttpStatus.CREATED)
  public Post createPost(@RequestBody Post post, @PathVariable int id) {
      var newPost = new Post();
      newPost.setUserId(id);
      newPost.setSlug(post.getSlug());
      newPost.setTitle(post.getTitle());
      newPost.setBody(post.getBody());
    posts.add(newPost);
      return newPost;
  }
}
// END
