package com.social.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private PostDAO postDao;

	public List<Post> retrieveAllPost() {
		return postDao.retrieveAllPost();
	}

	public List<Post> retrieveUserPost(int userId) {
		return postDao.retrieveUserPost(userId);
	}
	
	public List<Post> retrievePostByUserIdandPostId(int userId,int postId)
	{
		return postDao.retrievePostByUserIdandPostId(userId, postId);
	}
    public Post addPost(Post post) 
    {
    	return postDao.addPost(post);
    }
}
