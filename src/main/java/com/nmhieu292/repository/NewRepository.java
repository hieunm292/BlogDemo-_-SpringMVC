package com.nmhieu292.repository;

import com.nmhieu292.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	
}
