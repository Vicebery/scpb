package com.scpb.service;

import com.scpb.entity.MemberEnterprise;

import java.util.List;

public interface MemberEnterpriseService {
    void modifyLimitById(String limit,String id);

    String getLimitById(String id);

    void addMemberEnterprise(String id);

	List<MemberEnterprise> getAllMemberEnterprise();
}
