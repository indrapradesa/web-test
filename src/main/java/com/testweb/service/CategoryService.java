package com.testweb.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.testweb.entity.Category;
import com.testweb.repo.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }

    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }

    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    // public List<Category> findByName(String keyword) {
    // return repo.findByNameContains(keyword);
    // }

}
