package com.nec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nec.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	
}
