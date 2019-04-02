package com.scpb.service;

import com.scpb.entity.Supplier;

import java.util.List;

public interface SupplierService {

    void addSupplier(String id,String name);

	List<Supplier> getSupplierById(String id);
}
