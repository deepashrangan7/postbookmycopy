package com.cts.postbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.postbook.modal.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Integer>{

}
