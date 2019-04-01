package com.scpb.dao;

import com.scpb.entity.Enterprise;
import com.scpb.entity.MemberEnterprise;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberEnterpriseDao {
	String selectLimitById(String id);

    void updateLimitById(@Param("limit")String limit, @Param("id")String id);

    void insertMemberEnterprise(String id);

	List<MemberEnterprise> selectAllMemberEnterprise();
}
