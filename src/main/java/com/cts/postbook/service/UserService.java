package com.cts.postbook.service;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.postbook.modal.Post;
import com.cts.postbook.modal.Users;
import com.cts.postbook.repository.UserRespository;

@Service
public class UserService {
	@Autowired
	private UserRespository userRepo;

	public void createUser() {
		Users u = new Users("deepash", "1234");
		u.setPosts(Arrays.asList(new Post("im new", "1st", 1), new Post("im old", "2nd", 1)));
		userRepo.save(u);
		u = new Users("gandhi", "123");
		u.setPosts(Arrays.asList(new Post("gandhi", "1st", 2), new Post("gandhi2", "2nd", 2)));

		userRepo.save(u);

	}

	public List<Post> getAllPost(String name) {
		Users user = userRepo.findUser(name);
//System.out.println(user+"");
		if (user != null)
			return user.getPosts();
		return null;
	}

	@Transactional
	public boolean addNewPost(Post post, String name) {
		if (post != null && name != null) {

			Users user = userRepo.findUser(name);
			Post newPost = new Post(post.getBody(), post.getTitle(), user.getId());
			user.getPosts().add(newPost);

			userRepo.save(user);
			return true;
		}
		return false;
	}

	public boolean edit(Post post, String name, Integer id) {
		Users user = null;
		if (name != null)
			user = userRepo.findUser(name);
		if (post != null && id != null && name != null && user != null) {
			for (int i = 0; i < user.getPosts().size(); i++) {
				if (user.getPosts().get(i).getId() == id) {
					Post p = new Post(post.getBody(), post.getTitle(), user.getId());
					p.setId(id);
					user.getPosts().set(i, p);
					userRepo.save(user);
					return true;
				}
			}
		}
		return false;
	}

	public Post delete(String name, Integer id) {
		Post post = null;
		if (name != null) {
			Users user = userRepo.findUser(name);
			if (user != null && id != null) {
				List<Post> allPosts = user.getPosts();
				for (int ind = 0; ind < allPosts.size(); ind++) {
					if (allPosts.get(ind).getId() == id) {
						post = allPosts.get(ind);
						user.getPosts().remove(ind);
						userRepo.save(user);
						return post;
					}
				}
			}
		}
		return post;
	}

}
