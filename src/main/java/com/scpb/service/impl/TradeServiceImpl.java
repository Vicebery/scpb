package com.scpb.service.impl;

import com.scpb.dao.TradeDao;
import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {
    @Resource(name = "tradeDao")
    private TradeDao tradeDao;

    public void addTradeInformation(TradeInformation tradeInformation) {
        tradeDao.insertTradeInformation(tradeInformation);
    }

    @Override
    public void addPartTradeInformation(TradeInformation tradeInformation) {
        tradeDao.insertPartTradeInformation(tradeInformation);
    }

    @Override
    public TradeInformation getTradeInfById(String id) {
        return tradeDao.selectTradeInfById(id);
    }

    @Override
    public void modifyTradeInfById(String id, int verifyInf, String receiveCT, String remainCT) {
        tradeDao.updateTradeInfById(id,verifyInf,receiveCT,remainCT);
    }
}
