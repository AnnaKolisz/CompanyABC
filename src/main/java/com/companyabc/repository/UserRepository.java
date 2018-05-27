package com.companyabc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.companyabc.entity.Position;
import com.companyabc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 List<User> findAllByOrderBySurnameAsc();
	 
	 User findById(long Id);
	 
	 @Query(
			  value = "SELECT * FROM User GROUP BY position_id", 
			  countQuery = "SELECT count(*) FROM User", 
			  nativeQuery = true)
			List<User> findAllUsersWithPosition(int id);

}
