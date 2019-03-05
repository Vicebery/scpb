package com.scpb.service;

import com.scpb.entity.Enterprise;

public interface EnterpriseService {
	public Enterprise getEnterpriseById(String id);
	public void addEnterprise(Enterprise enterprise);
}
