package com.nmhieu292.api.admin;

import com.nmhieu292.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nmhieu292.dto.NewDTO;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {

    @Autowired
    private INewService newService;

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO) {

        return newService.save(newDTO);
    }

    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO updateNewDTO) {

        return newService.save(updateNewDTO);
    }

    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody long[] ids) {

        newService.delete(ids);
    }

//    @GetMapping("/api/new")
//    public NewDTO getAll() {
//
//        return newService.findAll();
//    }
}


