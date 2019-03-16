package com.scpb.service.impl;

import com.scpb.dao.CoreEnterpriseDao;
import com.scpb.entity.CoreEnterprise;
import com.scpb.service.CoreEnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("coreEnterpriseService")
public class CoreEnterpriseServiceImpl implements CoreEnterpriseService {
    @Resource(name = "coreEnterpriseDao")
    private CoreEnterpriseDao coreEnterpriseDao;

    public void modifyLimitById(String limit, String id) {
        coreEnterpriseDao.updateLimitById(limit,id);
    }

    public String getLimitById(String id) {
        return coreEnterpriseDao.selectLimitById(id);
    }
}
