package com.cts.postbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.postbook.modal.Post;
import com.cts.postbook.service.UserService;

@RestController
@RequestMapping("/posts")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/create")
	public void create() {
		userService.createUser();
	}

	@GetMapping("/{name}")
	public List<Post> getAllPost(@PathVariable String name) {
		List<Post> allPosts = userService.getAllPost(name);
//		System.out.println(allPosts);
		return allPosts;
	}

	@PostMapping("/{name}")
	public ResponseEntity<Post> addNewPost(@RequestBody Post post, @PathVariable String name) {
		boolean flag = userService.addNewPost(post, name);
		if (flag) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		return null;
	}

	@PutMapping("/{name}/{id}")
	public ResponseEntity<Post> editPost(@RequestBody Post post, @PathVariable String name, @PathVariable Integer id) {
		boolean flag = userService.edit(post, name, id);
		if (flag) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		return null;

	}

	@DeleteMapping("/{name}/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable String name, @PathVariable Integer id) {
		Post post = userService.delete(name, id);
		if (post != null) {
			return new ResponseEntity<>(post, HttpStatus.OK);
		}
		return null;

	}
}
