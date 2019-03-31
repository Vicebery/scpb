package com.scpb.service.impl;

import com.scpb.dao.FactorDao;
import com.scpb.service.FactorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("factorService")
public class FactorServiceImpl implements FactorService {
    @Resource(name = "factorDao")
    private FactorDao factorDao;

    @Transactional
    public void addFactor(String id) {
        factorDao.insertFactor(id);
    }
}
