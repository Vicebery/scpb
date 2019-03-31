package com.scpb.service.impl;

import com.scpb.dao.CoreEnterpriseDao;
import com.scpb.entity.CoreEnterprise;
import com.scpb.entity.Enterprise;
import com.scpb.service.CoreEnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("coreEnterpriseService")
public class CoreEnterpriseServiceImpl implements CoreEnterpriseService {
    @Resource(name = "coreEnterpriseDao")
    private CoreEnterpriseDao coreEnterpriseDao;

    @Transactional
    public int modifyLimitById(String limit, String id) {
        return coreEnterpriseDao.updateLimitById(limit,id);
    }

    @Transactional
    public String getLimitById(String id) {
        return coreEnterpriseDao.selectLimitById(id);
    }

    @Transactional
    public List<Enterprise> getSuppliersById(String id) {
        return coreEnterpriseDao.selectSupplierById(id);
    }

    @Transactional
    public void addSupplier(String id, String mySupplier) {
        coreEnterpriseDao.insertSupplier(id,mySupplier);

    }

    @Transactional
    public void deleteSupplier(String id, String mySupplier) {
        coreEnterpriseDao.deleteSupplier(id,mySupplier);
    }
}
