package com.scpb.dao;

import com.scpb.entity.Enterprise;

public interface EnterpriseDao {
	int deleteByPrimaryKey(String id);
	 
    int insert(Enterprise record);
 
    Enterprise selectByPrimaryKey(String id);
    
    Enterprise getEnterpriseById(String id);

}
