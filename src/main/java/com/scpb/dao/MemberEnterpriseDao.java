package com.scpb.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberEnterpriseDao {
	String selectLimitById(String id);

    void updateLimitById(@Param("limit")String limit, @Param("id")String id);
}
