package com.scpb.service;

import com.scpb.entity.Enterprise;

import java.util.List;

public interface CoreEnterpriseService {
    int modifyLimitById(String limit,String id);

    String getLimitById(String id);

    void addCoreEnterprise(String id,String name);
}
