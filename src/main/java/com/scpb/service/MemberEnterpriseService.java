package com.scpb.service;

import com.scpb.entity.Enterprise;

import java.util.List;

public interface MemberEnterpriseService {
    void modifyLimitById(String limit,String id);

    String getLimitById(String id);

    List<Enterprise> getSuppliersById(String id);

    void addSupplier(String id, String mySupplier);

    void deleteSupplier(String id, String mySupplier);
}
