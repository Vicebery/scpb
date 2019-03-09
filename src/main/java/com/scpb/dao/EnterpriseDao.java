package com.scpb.dao;

import com.scpb.entity.Enterprise;

public interface EnterpriseDao {
	int deleteByPrimaryKey(String id);
	 
    void insertEnterprise(Enterprise enterprise);
 
    Enterprise selectByPrimaryKey(String id);
    
    Enterprise selectEnterpriseById(String id);

	int selectEnterpriseTypeById(String owerId);

}
