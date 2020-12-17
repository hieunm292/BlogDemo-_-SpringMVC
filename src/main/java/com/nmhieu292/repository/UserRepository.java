package com.nmhieu292.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nmhieu292.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
