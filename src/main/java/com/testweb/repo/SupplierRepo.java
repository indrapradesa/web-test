package com.testweb.repo;

import com.testweb.entity.Supplier;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {

}
