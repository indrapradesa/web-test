package com.testweb.service;

import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import com.testweb.entity.Product;
import com.testweb.repo.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Iterable<Product> findAll() {
        return repo.findAll();
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    public void updateProduct(Product product) {
        repo.save(product);
    }

    public List<Product> findByName(String keyword) {
        return repo.findByNameContains(keyword);
    }
}
