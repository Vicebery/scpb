package com.scpb.service;

import com.scpb.entity.Enterprise;

import java.util.List;

public interface SupplierService {

    List<Enterprise> getSuppliersById(String id);

    void addSupplier(String id, String mySupplier);

    void deleteSupplier(String id, String mySupplier);
}
