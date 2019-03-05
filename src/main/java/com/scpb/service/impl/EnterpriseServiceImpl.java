package com.scpb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scpb.dao.EnterpriseDao;
import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;

import javax.annotation.Resource;


@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService{
	@Resource(name = "enterpriseDao")
	private EnterpriseDao enterpriseDao;

	public void setEnterpriseDao(EnterpriseDao enterpriseDao) {
		this.enterpriseDao = enterpriseDao;
	}

	public Enterprise getEnterpriseById(String id){

		return enterpriseDao.getEnterpriseById(id);
	}

	public void addEnterprise(Enterprise enterprise) {

		enterpriseDao.insertEnterprise(enterprise);
	}
}
