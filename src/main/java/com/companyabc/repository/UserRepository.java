package com.companyabc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyabc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
