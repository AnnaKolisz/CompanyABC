package com.companyabc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyabc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 List<User> findAllByOrderByNameAsc();

}
