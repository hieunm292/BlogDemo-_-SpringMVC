package com.nmhieu292.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nmhieu292.converter.NewConverter;
import com.nmhieu292.dto.NewDTO;
import com.nmhieu292.entity.CategoryEntity;
import com.nmhieu292.entity.NewEntity;
import com.nmhieu292.repository.CategoryRepository;
import com.nmhieu292.repository.NewRepository;
import com.nmhieu292.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		//convert data tu dto qua entity
		for (NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDto(item); //convert qua entity va add vao models
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public long getTotalItem() {
		return (int) newRepository.count(); //select count(*) form new;
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDto(entity);
	}

//	@Override
//	@Transactional
//	public NewDTO insert(NewDTO newDTO) {
//		CategoryEntity category=categoryRepository.findOneByCode(newDTO.getCategoryId());
//		NewEntity newEntity=newConverter.toEntity(newDTO);
//		newEntity.setCategory(category);
//		newEntity=newRepository.save(newEntity);
//		return newConverter.toDto(newEntity);
//	}
//
//	@Override
//	@Transactional
//	public NewDTO update(NewDTO updateNew) {
//		NewEntity oldNew=newRepository.findOne(updateNew.getId());
//		CategoryEntity category=categoryRepository.findOneByCode(updateNew.getCategoryId());
//		oldNew.setCategory(category);
//		NewEntity updateNewFromNewBefore=newConverter.toEntity(oldNew,updateNew);
//		return newConverter.toDto(newRepository.save(updateNewFromNewBefore));
//	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		//insert == id== null/ update == id != null
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategory(category);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			newRepository.delete(id);
		}
	}
}
