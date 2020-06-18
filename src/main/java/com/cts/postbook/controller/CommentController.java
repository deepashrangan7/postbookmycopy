package com.cts.postbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.postbook.modal.Comments;
import com.cts.postbook.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentSevice;

	@PostMapping("/add/{name}/{pid}")
	public Comments addComment(@PathVariable String name, @PathVariable Integer pid, @RequestBody Comments comment) {

		boolean flag = commentSevice.addComment(comment, name, pid);
		if (flag)
			return comment;
		return null;
	}

	@GetMapping("/comments/{pid}")
	public List<Comments> getAllComments(@PathVariable Integer pid) {
		return commentSevice.getAllComments(pid);
	}

	@PutMapping("/comments/{cid}")
	public Comments editComment(@PathVariable Integer cid, @RequestBody Comments comment) {
		return commentSevice.editComment(comment, cid);

	}

	@DeleteMapping("/comments/{cid}")
	public void deleteComment(@PathVariable Integer cid) {
		commentSevice.deletecomment(cid);
	}
}
