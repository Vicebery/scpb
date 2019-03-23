package com.scpb.service;

public interface MemberEnterpriseService {
    void modifyLimitById(String limit,String id);

    String getLimitById(String id);
}
