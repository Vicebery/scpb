package com.scpb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scpb.dao.EnterpriseDao;
import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService{
	@Resource(name = "enterpriseDao")
	private EnterpriseDao enterpriseDao;

	public void setEnterpriseDao(EnterpriseDao enterpriseDao) {

		this.enterpriseDao = enterpriseDao;
	}

	@Transactional
	public Enterprise getEnterpriseById(String id){

		return enterpriseDao.selectEnterpriseById(id);
	}

	@Transactional
	public void addEnterprise(Enterprise enterprise) {

		enterpriseDao.insertEnterprise(enterprise);
	}

	@Transactional
	public int getEnterpriseTypeById(String owerId) {

		return enterpriseDao.selectEnterpriseTypeById(owerId);
	}

	@Transactional
	public void updateEnterprise(Enterprise enterprise) {

		enterpriseDao.updateEnterprise(enterprise);
	}
}
