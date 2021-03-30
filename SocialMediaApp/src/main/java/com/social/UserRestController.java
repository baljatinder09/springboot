package com.social;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.post.Post;
import com.social.post.PostService;

@RestController
@RequestMapping("users")
@Validated
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private PostService postService;

	@GetMapping
	public List<User> retrieveAllUser() {
		// TODO Auto-generated method stub
		return userService.retrieveAllUser();
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> findByUserId(@PathVariable @Min(1) int userId) {
		// TODO Auto-generated method stub
		return new ResponseEntity<User>(userService.findByUserId(userId),HttpStatus.OK);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		return userService.createUser(user);
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable int userId) {
		// TODO Auto-generated method stub
		System.out.print("Call deleteUser");
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/posts")
	public List<Post> retrieveAllPost()
	{
		return postService.retrieveAllPost();
	}
		
	@GetMapping("/{userId}/posts") 
	List<Post> retrieveUserPost(@PathVariable int userId)
	{
		return postService.retrieveUserPost(userId);
	}
	
	@GetMapping("/{userId}/posts/{postId}")
	List<Post> retrievePostByUserIdandPostId(@PathVariable int userId,@PathVariable int postId)
	{
		return postService.retrievePostByUserIdandPostId(userId, postId);
	}
    
	@PostMapping("/{userId}/posts")
	public Post addPost(@Valid @RequestBody Post post)
	{
		return  post;
	}
}
