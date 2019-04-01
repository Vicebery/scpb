package com.scpb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scpb.dao.EnterpriseDao;
import com.scpb.entity.Enterprise;
import com.scpb.service.EnterpriseService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


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
	public Enterprise getEnterpriseByAccount(String account) {
		return enterpriseDao.selectEnterpriseByAccount(account);
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

	@Transactional
	public String getEnterpriseIdByAccount(String account) {
		return enterpriseDao.selectEnterpriseIdByAccount(account);
	}

	@Transactional
	public List<Enterprise> getSuppliersById(String id) {
		return enterpriseDao.selectMySupplierById(id);
	}

	@Transactional
	public void addSupplier(String id, String mySupplier) {
		enterpriseDao.insertMySupplier(id,mySupplier);
	}

	@Transactional
	public void deleteSupplier(String id, String mySupplier) {
		enterpriseDao.deleteMySupplier(id,mySupplier);
	}

	@Transactional
	public String getBankById(String id) {
		return enterpriseDao.selectBankById(id);
	}

	@Transactional
	public void modifyBankById(String bank,String id) {
		enterpriseDao.updateBankById(bank,id);
	}
}
