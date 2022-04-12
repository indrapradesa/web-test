package com.testweb.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.testweb.entity.Supplier;
import com.testweb.repo.SupplierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    public Iterable<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    public void addSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }

    public void deleteById(Long id) {
        supplierRepo.deleteById(id);
    }

    public Optional<Supplier> findById(Long id) {
        return supplierRepo.findById(id);
    }

    public void updateSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }
}
