package com.scpb.service.impl;

import com.scpb.dao.MemberEnterpriseDao;
import com.scpb.entity.Enterprise;
import com.scpb.service.MemberEnterpriseService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("memberEnterpriseService")
public class MemberEnterpriseServiceImpl implements MemberEnterpriseService {
    @Resource(name = "memberEnterpriseDao")
    private MemberEnterpriseDao memberEnterpriseDao;

    @Transactional
    public void modifyLimitById(String limit, String id) {
    	memberEnterpriseDao.updateLimitById(limit,id);
    }

    @Transactional
    public String getLimitById(String id) {
        return memberEnterpriseDao.selectLimitById(id);
    }

    @Transactional
    public List<Enterprise> getSuppliersById(String id) {
        return memberEnterpriseDao.selectSupplierById(id);
    }

    @Transactional
    public void addSupplier(String id, String mySupplier) {
        memberEnterpriseDao.insertSupplier(id,mySupplier);
    }

    @Transactional
    public void deleteSupplier(String id, String mySupplier) {
        memberEnterpriseDao.deleteSupplier(id,mySupplier);
    }
}
