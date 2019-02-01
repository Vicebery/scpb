package com.scpb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scpb.dao.EnterpriseDao;
import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;


@Service
public class EnterpriseServiceImpl implements EnterpriseService{
	@Autowired
	private EnterpriseDao enterpriseDao;
	
	public Enterprise getEnterpriseById(String id){
		return enterpriseDao.selectByPrimaryKey(id);
	}
}
