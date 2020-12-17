package com.nmhieu292.repository;

import com.nmhieu292.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    CategoryEntity findOneByCode(String code);
}
