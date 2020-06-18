package com.cts.postbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.postbook.modal.Comments;
import com.cts.postbook.modal.Post;
import com.cts.postbook.modal.Users;
import com.cts.postbook.repository.CommentsRepository;
import com.cts.postbook.repository.PostRespository;
import com.cts.postbook.repository.UserRespository;

@Service
public class CommentService {
	@Autowired
	private CommentsRepository commentsRepository;
	@Autowired
	private PostRespository postRepository;
	@Autowired
	private UserRespository userRepo;

	public boolean addComment(Comments comment, String name, Integer pid) {
		Users user = userRepo.findUser(name);
		Optional<Post> opt = postRepository.findById(pid);
		Post post = null;
		if (opt.isPresent()) {
			post = opt.get();

			comment.setUid(user.getId());
			comment.setPost(post);
			post.getComments().add(comment);
			comment.setUid(user.getId());

			Post p = postRepository.save(post);
			if (p != null)
				return true;
		}
		return false;
	}

	public List<Comments> getAllComments(Integer pid) {
		Optional<Post> opt = postRepository.findById(pid);
		Post post = null;
		if (opt.isPresent()) {
			post = opt.get();
			return commentsRepository.findByPost(post);
		}
		return null;
	}

	public Comments editComment(Comments comment, Integer cid) {

		Optional<Comments> opt = commentsRepository.findById(cid);
		if (opt.isPresent()) {
			Comments commen = opt.get();
			commen.setComment(comment.getComment());
			commentsRepository.save(commen);
			return commen;
		}
		return null;
	}

	public void deletecomment(Integer cid) {
		 commentsRepository.deleteById(cid);
//		return null;
	}

}
