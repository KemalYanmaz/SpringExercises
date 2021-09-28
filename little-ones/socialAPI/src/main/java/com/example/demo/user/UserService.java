package com.example.demo.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location.Location;

@Service
public class UserService {
	User user1 = new User(1,"Kemal","Yanmaz",new Location(1,"Kocaeli"),"ulaskemalyanmaz@gmail.com");
	User user2 = new User(2,"Ulaş","Yanmaz",new Location(2,"Ankara"),"test@gmail.com");
	List<User> users = Arrays.asList(user1,user2);
	
	public List<User> getUsers(){
		return users;
	}
}
