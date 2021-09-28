package com.example.demo.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return postService.getPosts();
	}

}
