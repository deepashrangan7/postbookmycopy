package com.cts.postbook.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.postbook.modal.Users;

@Repository
public interface UserRespository extends JpaRepository<Users, Integer>{

	@Query("select b from Users b where b.username=:name")
	Users findUser(String name);

}
