package com.nmhieu292.service;

import com.nmhieu292.dto.NewDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	long getTotalItem();
	NewDTO findById(long id);
//	NewDTO insert(NewDTO dto);
//	NewDTO update(NewDTO updateNew);
	NewDTO save(NewDTO dto);
	void delete(long[] ids);

}
