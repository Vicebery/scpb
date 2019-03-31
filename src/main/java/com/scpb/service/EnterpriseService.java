package com.scpb.service;

import com.scpb.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {
	public Enterprise getEnterpriseById(String id);
	public void addEnterprise(Enterprise enterprise);
	public int getEnterpriseTypeById(String owerId);
	public void updateEnterprise(Enterprise enterprise);

	String getEnterpriseIdByAccount(String account);
}
