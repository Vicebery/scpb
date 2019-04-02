package com.scpb.service.impl;

import com.scpb.dao.SupplierDao;
import com.scpb.entity.Enterprise;
import com.scpb.entity.Supplier;
import com.scpb.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Resource(name = "supplierDao")
    private SupplierDao supplierDao;

    @Transactional
    public void addSupplier(String id,String name) {
        supplierDao.insertSupplier(id,name);
    }

	@Transactional
	public List<Supplier> getSupplierById(String id) {
		return supplierDao.selectSupplierById(id);
	}
}
