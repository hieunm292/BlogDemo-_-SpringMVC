package com.nmhieu292.service.impl;

import com.nmhieu292.converter.CategoryConverter;
import com.nmhieu292.dto.CategoryDTO;
import com.nmhieu292.entity.CategoryEntity;
import com.nmhieu292.repository.CategoryRepository;
import com.nmhieu292.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
     private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Map<String,String> findAll() {
        Map<String,String> result=new HashMap<>();
//            List<CategoryDTO> result=new ArrayList<>();
            List<CategoryEntity> entities=categoryRepository.findAll();
            for(CategoryEntity items : entities){
//                CategoryDTO dto= categoryConverter.toDto(items);
//                result.add(dto);
                result.put(items.getCode(),items.getName());
            }
            return result;

    }
}
