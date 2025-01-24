package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.user;

@Repository
public interface userRepo extends JpaRepository<user,Long>{

	@Query(value = "Select * from user e where e.user_name=?1 and e.password = ?2",nativeQuery = true)
	List<user> findByNameAndPassword(String userName, String password);

}
