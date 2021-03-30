package com.social.post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PostDAO {

	static List<Post> listPost;
	static {
		listPost = new ArrayList<Post>();
		listPost.add(new Post(1, 1, "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
				"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"));
		listPost.add(new Post(1, 2, "eum et est occaecati",
				"ullam et saepe reiciendis voluptatem adipisci\\nsit amet autem assumenda provident rerum culpa\\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\\nquis sunt voluptatem rerum illo velit"));
		listPost.add(new Post(1, 3, "nesciunt quas odio",
				"repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque"));
		listPost.add(new Post(1, 4, "dolorem eum magni eos aperiam quia",
				"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"));
		}
	
	
	public List<Post> retrieveAllPost()
	{
		return listPost;
	}
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<Post> retrieveUserPost(int userId) {
		List<Post> listofPost = listPost.stream().filter(post -> post.getUserId() == userId)
				.collect(Collectors.toList());
		return listofPost;
	}
    /**
     * 
     * @param userId
     * @param postId
     * @return
     */
	public List<Post> retrievePostByUserIdandPostId(int userId, int postId) {
		List<Post> listofPost = listPost.stream()
				.filter(post -> (post.getUserId() == userId && post.getPostId() == postId))
				.collect(Collectors.toList());
		return listofPost;
	}
   /**
    * 
    * @param post
    * @return
    */
	public Post addPost(Post post) {
		listPost.add(post);
		return post;
	}
}
