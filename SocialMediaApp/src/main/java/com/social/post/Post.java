package com.social.post;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User for POST")
public class Post {
	
	
	@NotNull(message = "Please enter userId")
	private int userId;
	
	@ApiModelProperty(notes="PostId should not be blank")
	@NotNull(message = "Please enter postId")
	private int postId;
	@NotBlank(message = "Title is mandatory")
	@Size(min=4, max=1000,message="Minimum word for title should be more than 4")
	private String title;
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	@Past
	private Date createdDate;
	private Date modifiedDate;

	public Post()
	{
		
	}
	
	public Post(int userId, int postId,String title, String description) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.userId = userId;
	}

	public Post(int userId,int postId,String title, String description, Date createdDate, Date modifiedDate) {
		super();
		this.userId=userId;
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.userId = userId;
	}

	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		if (createdDate == null)
			return new Date();
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		if (modifiedDate == null)
			return new Date();
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
