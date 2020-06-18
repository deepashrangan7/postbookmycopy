package com.cts.postbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.postbook.modal.Comments;
import com.cts.postbook.modal.Post;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

	List<Comments> findByPost(Post post);
}
