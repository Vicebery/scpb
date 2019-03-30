package com.scpb.dao;

import com.scpb.entity.Enterprise;

import java.util.List;

public interface EnterpriseDao {
	int deleteByPrimaryKey(String id);
	 
    void insertEnterprise(Enterprise enterprise);
 
    Enterprise selectByPrimaryKey(String id);
    
    Enterprise selectEnterpriseById(String id);

	int selectEnterpriseTypeById(String owerId);

	void updateEnterprise(Enterprise enterprise);

    String selectEnterpriseIdByAccount(String account);
}
