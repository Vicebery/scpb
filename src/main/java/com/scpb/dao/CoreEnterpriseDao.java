package com.scpb.dao;

import org.apache.ibatis.annotations.Param;

public interface CoreEnterpriseDao {
    String selectLimitById(String id);

    int updateLimitById(@Param("limit")String limit, @Param("id")String id);
}
