package com.nmhieu292.service;

import com.nmhieu292.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface ICategoryService {
    Map<String, String> findAll();
}
