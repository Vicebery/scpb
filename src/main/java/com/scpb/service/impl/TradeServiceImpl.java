package com.scpb.service.impl;

import com.scpb.dao.TradeDao;
import com.scpb.entity.ChainTicket;
import com.scpb.entity.TradeInformation;
import com.scpb.service.TradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {
    @Resource(name = "tradeDao")
    private TradeDao tradeDao;

    @Transactional
    public void addTradeInformation(TradeInformation tradeInformation) {
        tradeDao.insertTradeInformation(tradeInformation);
    }

    @Transactional
    public void addPartTradeInformation(TradeInformation tradeInformation) {
        tradeDao.insertPartTradeInformation(tradeInformation);
    }

    @Transactional
    public TradeInformation getTradeInfById(String id) {
        return tradeDao.selectTradeInfById(id);
    }

    @Transactional
    public void modifyTradeInfById(String id, int verifyInf, String receiveCT, String remainCT) {
        tradeDao.updateTradeInfById(id,verifyInf,receiveCT,remainCT);
    }

    @Override
    public List<String> getCTidBySecondParty(String id) {
        return tradeDao.selectCTidBySecondParty(id);
    }

    @Override
    public TradeInformation getTradeInfByPayCT(String payCT) {
        return tradeDao.selectTradeInfByPayCT(payCT);
    }

    @Transactional
	public void setVerifyInfByPayCTId(String chainTicketId, int verifyInf) {
		tradeDao.updateVerifyInfByPayCTId(chainTicketId, verifyInf);
	}
}
