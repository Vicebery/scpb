package com.scpb.service.impl;

import com.scpb.dao.EnterpriseDao;
import com.scpb.dao.SupplierDao;
import com.scpb.entity.Enterprise;
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
    public List<Enterprise> getSuppliersById(String id) {

        return supplierDao.selectSupplierById(id);
    }

    @Transactional
    public void addSupplier(String id, String mySupplier) {
        supplierDao.insertSupplier(id,mySupplier);
    }

    @Transactional
    public void deleteSupplier(String id, String mySupplier) {
        supplierDao.deleteSupplier(id,mySupplier);
    }
}
