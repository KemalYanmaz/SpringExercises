package com.example.demo.post;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location.Location;
import com.example.demo.user.User;

@Service
public class PostService {

	User user1 = new User(1,"Kemal","Yanmaz",new Location(1,"Kocaeli"),"ulaskemalyanmaz@gmail.com");
	User user2 = new User(2,"Ulaş","Yanmaz",new Location(2,"Ankara"),"test@gmail.com");
	Post post1 = new Post(1,"26.09.2021",user1,"Hello that is a post sample id 1");
	Post post2 = new Post(2,"26.09.2021",user2,"Hello that is a post sample id 2");
	List<Post> posts = Arrays.asList(post1,post2);
	
	public List<Post> getPosts(){
		return posts;
	}
}
